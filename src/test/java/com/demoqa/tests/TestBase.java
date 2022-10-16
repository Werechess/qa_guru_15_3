package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.util.Locale;

import static com.demoqa.utils.RandomUtils.Gender.getRandomGender;
import static com.demoqa.utils.RandomUtils.Month.getRandomMonth;
import static com.demoqa.utils.RandomUtils.getRandomDay;

public class TestBase {

    Faker faker = new Faker();
    Faker fakerRu = new Faker(new Locale("ru"));

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(), // or getRandomEmail(),
            gender = getRandomGender(),
            mobilePhone = faker.phoneNumber().subscriberNumber(10), // or getRandomPhone(),
            dayOfBirth = getRandomDay(),
            monthOfBirth = getRandomMonth(),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1921, 2007)),
            subject = "Computer Science",
            firstHobby = "Sports",
            secondHobby = "Reading",
            thirdHobby = "Music",
            picture = "Java_logo.svg",
            address = fakerRu.address().streetAddress(), // or getRandomString(19),
            state = "Haryana",
            city = "Karnal";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
}
