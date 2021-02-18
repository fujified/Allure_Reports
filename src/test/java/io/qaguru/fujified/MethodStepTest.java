package io.qaguru.fujified;

import org.junit.jupiter.api.Test;

public class MethodStepTest {
    public BaseSteps steps = new BaseSteps();

    private static final String REPOSITORY = "fujified/allure";
    private static final String ISSUE_NUMBER = "#1";
    private static final String ISSUES = "Issues";

    @Test
    public void testIssueSearch() {
        steps.openMainPage();
        steps.findRepo(REPOSITORY);
        steps.goToRepo(REPOSITORY);
        steps.goToIssues(ISSUES);
        steps.checkIt(ISSUE_NUMBER);
    }
}


