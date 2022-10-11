package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsDialogComponent {

    private final static String DIALOG_HEADER_TEXT = "Thanks for submitting the form";

    private final SelenideElement dialogWindow = $(".modal-dialog"),
            dialogHeader = $("#example-modal-sizes-title-lg"),
            tableElement = $(".table-responsive");


    public void checkResult(String key, String value) {
        tableElement.$(byText(key)).parent().shouldHave(text(value));
    }

    public void checkVisible() {
        dialogWindow.should(appear);
        dialogHeader.shouldHave(text(DIALOG_HEADER_TEXT));
    }
}
