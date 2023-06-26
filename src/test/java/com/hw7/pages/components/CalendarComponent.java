package com.hw7.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String randomDay, String randomMonth, String randomYear) {

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(randomMonth);
        $(".react-datepicker__year-select").selectOption(randomYear);
        $(".react-datepicker__day--0"+randomDay+":not(.react-datepicker__day--outside-month)").click();
    }

}
