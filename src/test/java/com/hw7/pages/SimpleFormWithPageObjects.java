package com.hw7.pages;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import com.hw7.pages.components.CalendarComponent;
import com.hw7.pages.components.CityComponent;
import com.hw7.pages.components.VerifyComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.hw7.utils.RandomUtils.*;

public class SimpleFormWithPageObjects {
    //String loginInputLocator= "#firstName"; - bed practice
    public Faker faker = new Faker();
    CalendarComponent calendarComponent = new CalendarComponent();
    CityComponent cityComponent = new CityComponent();
    VerifyComponent verifyResultWO = new VerifyComponent();
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement ganderWrapper = $("#genterWrapper").parent();
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement dayBirthInput = $("#dateOfBirthInput");
    SelenideElement currentAddressInput = $("#currentAddress");
    static SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement pictureFile = $("#uploadPicture");
    SelenideElement submitButton = $("#submit");

    public SimpleFormWithPageObjects openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public SimpleFormWithPageObjects removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    public SimpleFormWithPageObjects setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public SimpleFormWithPageObjects setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public SimpleFormWithPageObjects setUserEmailName(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public SimpleFormWithPageObjects setGender(String value) {
        ganderWrapper.$(byText(value)).click();
        return this;
    }

    public SimpleFormWithPageObjects setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public SimpleFormWithPageObjects setBirthDay(String randomDay, String randomMonth, String randomYear) {
        dayBirthInput.click();
        calendarComponent.setDate(randomDay, randomMonth, randomYear);
        return this;
    }

    public SimpleFormWithPageObjects setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

     public SimpleFormWithPageObjects setHobby(String randomHobby) {
        hobbiesWrapper.$(byText(randomHobby)).click();
        return this;
    }

    public SimpleFormWithPageObjects setSubjects(String value) {
        subjectsInput.setValue(value);
        subjectsInput.pressEnter();
        return this;
    }

    public SimpleFormWithPageObjects setCity(String randomState, String randomCity) {
     cityComponent.setCity(randomState, randomCity);
        return this;
    }

    public SimpleFormWithPageObjects uploadPicture(String value) {
        pictureFile.uploadFile(new File(value));
        return this;
    }

    public SimpleFormWithPageObjects clickSubmit() {
        submitButton.click();
        return this;
    }

    public SimpleFormWithPageObjects checkResult(String fromTable, String fromUser) {
        verifyResultWO.verifyResults(fromTable, fromUser);
        return this;
    }

}

