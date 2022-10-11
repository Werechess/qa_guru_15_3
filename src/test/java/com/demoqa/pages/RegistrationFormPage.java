package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsDialogComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private final static String FORM_HEADER_TEXT = "Student Registration Form";

    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final ResultsDialogComponent resultsDialogComponent = new ResultsDialogComponent();

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            mobilePhoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsAutocompleteInput = $("#subjectsInput"),
            hobbiesCheckboxWrapper = $("#hobbiesWrapper"),
            pictureUploader = $("#uploadPicture"),
            addressTextarea = $("#currentAddress"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            stateAndCitySelectWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            formHeader = $(".practice-form-wrapper > h5");


    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderRadio.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setMobilePhone(String value) {
        mobilePhoneInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjectsAutocompleteInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        hobbiesCheckboxWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setPicture(String value) {
        pictureUploader.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        addressTextarea.setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateDropdown.click();
        stateAndCitySelectWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityDropdown.click();
        stateAndCitySelectWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsDialogComponent.checkVisible();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsDialogComponent.checkResult(key, value);
        return this;
    }

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        formHeader.shouldHave(text(FORM_HEADER_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
}
