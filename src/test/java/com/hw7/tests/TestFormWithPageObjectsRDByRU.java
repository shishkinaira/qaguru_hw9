package com.hw7.tests;
import com.hw7.pages.SimpleFormWithPageObjects;
import org.junit.jupiter.api.Test;

import static com.hw7.utils.RandomUtils.*;

public class TestFormWithPageObjectsRDByRU extends TestBase {
    SimpleFormWithPageObjects simpleFormWithPageObjects = new SimpleFormWithPageObjects();
    @Test
    void successfulRegistrationTest() {

        //обьявляем переменные и заносим в них рандомную дату из RundomUtils
        String TestFirstName = getRandomString(10),
                TestLastN = getRandomString(10),
                userEmail = getRandomEmail(),
                userGander = getRandomGender(),
                randomPhone = getRandomPhone(),
                randomCurrentAddress = getRandomCurrentAddress();

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