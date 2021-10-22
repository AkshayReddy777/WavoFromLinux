package org.example.src;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SettignsPageTest extends BaseTest {
    protected DashboardPage dashboardPage;
    protected SettingPage settingPage;

    @Test
    public void settingsPageTest() throws InterruptedException {

        loginPage.doLogin(loginEmail,loginPassword);
        dashboardPage = PageFactory.initElements(driver , DashboardPage.class);
        dashboardPage.userNavigationRibbon.goTo("Settings");
        settingPage = PageFactory.initElements(driver, SettingPage.class);
        settingPage.changeUserName();
        Assert.assertTrue(settingPage.userName.getAttribute("value").toString().equals("madhoo") || settingPage.userName.getAttribute("value").toString().equals("MadhooBandi") );
    }

}
