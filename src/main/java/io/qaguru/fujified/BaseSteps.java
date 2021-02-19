package io.qaguru.fujified;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {
    private static final String BASE_URL = "https://github.com";

    @Step("open main page")
    public void openMainPage() { open(BASE_URL); }

    @Step("looking for a repository {repository}")
    public void findRepo(final String repository) {
        $(".header-search-input").setValue(repository).submit();
    }

    @Step("go to repository {repository}")
    public void goToRepo(final String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("go to Issues")
    public void goToIssues(final String issue) {
        $(withText((issue))).click();
    }

    @Step("check that Issue with number {number} exists")
    public void checkIt(final String number) {
        $(withText(number)).should(Condition.visible);
    }
}
