package org.example.src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CampaignsPageTest extends BaseTest{
    protected DashboardPage dashboardPage;
    protected CampaignsPage campaignsPage;

    @BeforeClass
    public void setEmailAccountsPage() {
        loginPage.doLogin(loginEmail, loginPassword);
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.userNavigationRibbon.goTo("Campaigns");

        campaignsPage = PageFactory.initElements(driver, CampaignsPage.class);
    }

    @Test
    public void createCampaign(){
        String campaignName = "CRM";
        campaignsPage.createCampaign(campaignName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement title = driver.findElement(By.cssSelector("div>p.page-description.m-0.text-capitalize"));
        String actual = title.getAttribute("innerText");
        Assert.assertEquals(actual, campaignName );
    }

    @Test
    public void deleteCampaign(){
        String campaignName = "CRM";
        campaignsPage.deleteCampaign(campaignName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement successMessage = driver.findElement(By.cssSelector("div>div.mb-20.alert-dismissible.alert-icon.alert.alert-success"));
        String actual = successMessage.getAttribute("innerText");
        Assert.assertTrue(actual.endsWith("deleted") );
    }
}
