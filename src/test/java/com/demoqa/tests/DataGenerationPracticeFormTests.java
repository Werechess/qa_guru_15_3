package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

class DataGenerationPracticeFormTests extends TestBase {

    private final RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillFormWithMaximumDataTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
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
                .setCity(city)
                .clickSubmit()

                .checkResultsTableVisible()
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
    }

    @Test
    void fillFormWithMinimumDataTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setMobilePhone(mobilePhone)
                .clickSubmit()

                .checkResultsTableVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobilePhone);
    }
}
