package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PageObjectPracticeFormTests extends TestBase {

    private final RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    private final String firstName = "Jane",
            lastName = "Doe",
            email = "realjanedoe@gmail.com",
            gender = "Female",
            mobilePhone = "1234567890",
            dayOfBirth = "31",
            monthOfBirth = "December",
            yearOfBirth = "1999",
            subject = "Computer Science",
            firstHobby = "Sports",
            secondHobby = "Reading",
            thirdHobby = "Music",
            picture = "Java_logo.svg",
            address = "Beautiful Place",
            state = "Haryana",
            city = "Karnal";

    @Test
    @Disabled("Deprecated")
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
    @Disabled("Deprecated")
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
