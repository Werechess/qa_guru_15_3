package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.utils.Attach;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

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
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("browserVersion", "100.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
