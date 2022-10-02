package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

class PracticeFormTests extends TestBase {

    String firstName = "Jane",
            lastName = "Doe",
            email = "realjanedoe@gmail.com",
            gender = "Female",
            mobilePhone = "1234567890",
            dateOfBirth = "31 December,1999",
            subject = "Computer Science",
            firstHobby = "Sports",
            secondHobby = "Reading",
            thirdHobby = "Music",
            picture = "Java_logo.svg",
            address = "Beautiful Place",
            state = "Haryana",
            city = "Karnal";

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper > h5").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobilePhone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--031:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(firstHobby)).click();
        $("#hobbiesWrapper").$(byText(secondHobby)).click();
        $("#hobbiesWrapper").$(byText(thirdHobby)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        checkTable("Student Name", firstName + " " + lastName);
        checkTable("Student Email", email);
        checkTable("Gender", gender);
        checkTable("Mobile", mobilePhone);
        checkTable("Date of Birth", dateOfBirth);
        checkTable("Subjects", subject);
        checkTable("Hobbies", firstHobby + ", " + secondHobby + ", " + thirdHobby);
        checkTable("Picture", picture);
        checkTable("Address", address);
        checkTable("State and City", state + " " + city);
    }

    void checkTable(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}
