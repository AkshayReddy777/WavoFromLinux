package org.example.src;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DashboardPageTest extends BaseTest {

    protected DashboardPage dashboardPage;

    @BeforeClass
    public void setupForDashboardTestClass() {
        loginPage.doLogin(loginEmail, loginPassword);
    }

    @BeforeMethod
    public void beforeEachTestCase() {
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
    }

    @Test(priority = 0)
    public void goToSettingsTest() {
        dashboardPage.userNavigationRibbon.goTo("Settings");
        Assert.assertEquals(driver.getCurrentUrl(), "https://zodha3.wavo.co/settings");
    }

    @Test(priority = 1)
    public void goToAggregateReportsTest() {
        dashboardPage.userNavigationRibbon.goToSpecificReports("Aggregate Report");
        Assert.assertEquals(driver.getCurrentUrl(), "https://zodha3.wavo.co/reports/campaign-aggregates");
    }

    @Test(priority = 2)
    public void goToDateRangeReportsTest() {
        dashboardPage.userNavigationRibbon.goToSpecificReports("Date Range Report");
        Assert.assertEquals(driver.getCurrentUrl(), "https://zodha3.wavo.co/reports/date-range");
    }

    @Test(priority = 3)
    public void goToContactsTest() {
        dashboardPage.userNavigationRibbon.goTo("Contacts");
        Assert.assertEquals(driver.getCurrentUrl(), "https://zodha3.wavo.co/contacts");
    }

    @Test(priority = 4)
    public void goToLinkedInTest() {
        dashboardPage.userNavigationRibbon.goTo("Linkedin");
        Assert.assertEquals(driver.getCurrentUrl(), "https://zodha3.wavo.co/linkedin-access-request/create");
    }

    @Test(priority = 5)
    public void goToEmailAccountsTest() {
        dashboardPage.userNavigationRibbon.goTo("Email Accounts");
        Assert.assertEquals(driver.getCurrentUrl(), "https://zodha3.wavo.co/email-accounts?");
    }

    @Test(priority = 6)
    public void goToClientsTest() {
        dashboardPage.userNavigationRibbon.goTo("Clients");
        Assert.assertEquals(driver.getCurrentUrl(), "https://zodha3.wavo.co/clients?");
    }

    @Test(priority = 7)
    public void goToCampaignsTest() {
        dashboardPage.userNavigationRibbon.goTo("Campaigns");
        Assert.assertEquals(driver.getCurrentUrl(), "https://zodha3.wavo.co/campaigns?");
    }

    @Test(priority = 8)
    public void goToDashboardTest() {
        dashboardPage.userNavigationRibbon.goTo("Dashboard");
        Assert.assertEquals(driver.getCurrentUrl(), "https://zodha3.wavo.co/home");
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.userAvatarRibbon.doLogout();
    }

}
