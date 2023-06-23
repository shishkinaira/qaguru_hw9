package com.hw7.tests;
import com.github.javafaker.Faker;
import com.hw7.pages.SimpleFormWithPageObjects;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.hw7.utils.RandomUtils.*;
import static java.util.Locale.JAPAN;

public class TestFormWithPageObjectsRDByFaker extends TestBase {
    SimpleFormWithPageObjects simpleFormWithPageObjects = new SimpleFormWithPageObjects();
    @Test
    void successfulRegistrationTest() {
        //Рандомный факт  Пробовала локаль Японии  Очень красиво но имейл на валидируется с иероглифами
        Faker faker = new Faker();

        //обьявляем переменные и заносим в них рандомную дату из Faker
        String TestFirstName = faker.name().firstName(),
                TestLastN = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                randomPhone = faker.phoneNumber().subscriberNumber(10),
                randomCurrentAddress = faker.address().fullAddress(),
                userGander = getRandomGender();

        //Проверка заполения формы
        simpleFormWithPageObjects.openPage()
                .removeBanner()
                .setFirstName(TestFirstName)
                .setLastName(TestLastN)
                .setUserEmailName(userEmail)
                .setGender(userGander)
                .setUserNumber(randomPhone)
                .setBirthDay("30", "October", "2008")
                .setCurrentAddress(randomCurrentAddress)
                .setHobby("Sports")
                .setSubjects("Maths")
                .setCity("NCR","Delhi")
                .uploadPicture("src/test/resources/1.png")
                .clickSubmit();

        //Проверка данных попапа
        simpleFormWithPageObjects.checkResult("Student Name", TestFirstName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGander)
                .checkResult("Mobile", randomPhone)
                .checkResult("Date of Birth", "30 October,2008")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.png")
                .checkResult("Address", randomCurrentAddress)
                .checkResult("State and City", "NCR Delhi");
    }
}