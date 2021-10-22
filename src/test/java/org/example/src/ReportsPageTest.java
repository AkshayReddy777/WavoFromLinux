package org.example.src;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ReportsPageTest extends BaseTest {

    protected ReportsPage reportsPage;
    protected DashboardPage dashboardPage;

    @Test
    public void reportsPageTest() {

        loginPage.doLogin(loginEmail , loginPassword);
        dashboardPage = PageFactory.initElements(driver , DashboardPage.class);
        dashboardPage.userNavigationRibbon.goTo("Reports");
        reportsPage = PageFactory.initElements(driver , ReportsPage.class);
        reportsPage.clickOnAggregateReports();
        dashboardPage.userNavigationRibbon.goTo("Reports");
        reportsPage.clickOnDateRangeReports();

    }

}
