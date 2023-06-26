package com.hw7.tests;
import com.github.javafaker.Faker;
import com.hw7.pages.SimpleFormWithPageObjects;
import org.junit.jupiter.api.Test;
import static com.hw7.utils.RandomUtils.*;

public class TestFormWithPageObjectsRandomData extends TestBase {
    SimpleFormWithPageObjects simpleFormWithPageObjects = new SimpleFormWithPageObjects();
    @Test
    void successfulRegistrationTest() {
        Faker faker = new Faker();

        //обьявляем переменные и заносим в них рандомную дату из RundomUtils
        String TestFirstName = faker.name().firstName(),
                TestLastN = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                randomPhone = getRandomPhone(),
                randomCurrentAddress = faker.address().fullAddress(),
                userGander = getRandomGender(),
                randomHobby = getRandomHobby(),
                randomSubjects = getRandomSubjects(),
                randomDay = getRandomDay(),
                randomMonth = getRandomMonth(),
                randomYear = getRandomYear(),
                randomState = getRandomState(),
                randomCity = getRandomCity(randomState);

        //Проверка заполения формы
        simpleFormWithPageObjects.openPage()
                .removeBanner()
                .setFirstName(TestFirstName)
                .setLastName(TestLastN)
                .setUserEmailName(userEmail)
                .setGender(userGander)
                .setUserNumber(randomPhone)
                .setBirthDay(randomDay, randomMonth, randomYear)
                .setCurrentAddress(randomCurrentAddress)
                .setHobby(randomHobby)
                .setSubjects(randomSubjects)
                .setCity(randomState, randomCity)
                .uploadPicture("src/test/resources/1.png")
                .clickSubmit();

        //Проверка данных попапа
        simpleFormWithPageObjects.checkResult("Student Name", TestFirstName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGander)
                .checkResult("Mobile", randomPhone)
                .checkResult("Date of Birth", randomDay + " " + randomMonth + "," + randomYear)
                .checkResult("Subjects", randomSubjects)
                .checkResult("Hobbies", randomHobby)
                .checkResult("Picture", "1.png")
                .checkResult("Address", randomCurrentAddress)
                .checkResult("State and City", randomState + " " + randomCity);
    }

}