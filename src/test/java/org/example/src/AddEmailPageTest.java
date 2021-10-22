package org.example.src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddEmailPageTest extends BaseTest{
    protected DashboardPage dashboardPage;
    protected EmailAccountsPage emailAccountsPage;
    protected AddEmailPage addEmailPage;

    @BeforeClass
    public void setEmailAccountsPage() {
        loginPage.doLogin(loginEmail, loginPassword);
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);


        dashboardPage.userNavigationRibbon.goTo("Email Accounts");
        emailAccountsPage = PageFactory.initElements(driver, EmailAccountsPage.class);
        emailAccountsPage.gotoAddEmailPage();
        addEmailPage = PageFactory.initElements(driver, AddEmailPage.class);
    }

    @Test
    public void addEmailFail(){
        addEmailPage.addEmail("Grino","Rino","grinorino1@gmail.com", "Abc234", "Baba");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.findElement(By.cssSelector("div.swal-title")).getAttribute("innerText");
        Assert.assertEquals(actual, "Error adding Email Account!");
    }
}
