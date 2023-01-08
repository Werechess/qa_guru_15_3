package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

class DataGenerationPracticeFormTests extends TestBase {

    private final RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @Tag("for_allure")
    void fillFormWithMaximumDataTest() {
        step("Open registration form", () -> {
            registrationFormPage.openPage();
        });

        step("Fill registration form", () -> {
            registrationFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setMobilePhone(mobilePhone)
                    .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                    .setSubjects(subject)
                    .setHobby(firstHobby)
                    .setHobby(secondHobby)
                    .setHobby(thirdHobby)
                    .setPicture(picture)
                    .setAddress(address)
                    .setState(state)
                    .setCity(city);
        });

        step("Submit registration form", () -> {
            registrationFormPage.clickSubmit();
        });

        step("Check results in opened table", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", mobilePhone)
                    .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", firstHobby + ", " + secondHobby + ", " + thirdHobby)
                    .checkResult("Picture", picture)
                    .checkResult("Address", address)
                    .checkResult("State and City", state + " " + city);
        });
    }

    @Test
    void fillFormWithMinimumDataTest() {
        step("Open registration form", () -> {
            registrationFormPage.openPage();
        });

        step("Fill registration form", () -> {
            registrationFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setGender(gender)
                    .setMobilePhone(mobilePhone);
        });

        step("Submit registration form", () -> {
            registrationFormPage.clickSubmit();
        });

        step("Check results in opened table", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", mobilePhone);
        });
    }
}
