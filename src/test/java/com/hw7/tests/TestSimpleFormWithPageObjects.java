package com.hw7.tests;
import com.hw7.pages.SimpleFormWithPageObjects;
import org.junit.jupiter.api.Test;

public class TestSimpleFormWithPageObjects extends TestBase {
    SimpleFormWithPageObjects simpleFormWithPageObjects = new SimpleFormWithPageObjects();
    @Test
    void successfulRegistrationTest() {
        //Проверка заполения формы
        simpleFormWithPageObjects.openPage()
                .setFirstName("TestFirstName")
                .setLastName("TestLastN")
                .setUserEmailName("test@test.test")
                .setGender("Other")
                .setUserNumber("1111111111")
                .setBirthDay("30", "October", "2008")
                .setCurrentAddress("TestCurrentAddress")
                .setHobby("Sports")
                .setSubjects("Maths")
                .setCity("NCR","Delhi")
                .uploadPicture("src/test/resources/1.png")
                .clickSubmit();

        //Проверка данных попапа
        simpleFormWithPageObjects.chekResult("Student Name", "TestFirstName")
                .chekResult("Student Email", "test@test.test")
                .chekResult("Gender", "Other")
                .chekResult("Mobile", "1111111111")
                .chekResult("Date of Birth", "30 October,2008")
                .chekResult("Subjects", "Maths")
                .chekResult("Hobbies", "Sports")
                .chekResult("Picture", "1.png")
                .chekResult("Address", "TestCurrentAddress")
                .chekResult("State and City", "NCR Delhi");
    }
}