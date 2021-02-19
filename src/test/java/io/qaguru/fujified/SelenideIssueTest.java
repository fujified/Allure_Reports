package io.qaguru.fujified;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;

public class SelenideIssueTest {
    private static final String BASE_URL = "https://github.com";
    private static final String ISSUES = "Issues";
    private static final String REPOSITORY = "fujified/allure";
    private static final String ISSUE_NUMBER = "#1";

    @Test
    @Owner("mr spock")
    @Tags({@Tag("web"), @Tag("critical")})
    @Link(name = "Base URL", value = BASE_URL)

    @Feature("Issues")
    @Story("Search for an Issues in an existing repository")
    @DisplayName("Search Issue by number in repository")

    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        parameter("Repository", REPOSITORY);
        parameter("Issue Number", ISSUE_NUMBER);

        open(BASE_URL);
        $(".header-search-input").setValue(REPOSITORY).submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText(ISSUES)).click();
        $(withText(ISSUE_NUMBER)).should(Condition.visible);
    }
}
