package org.example.src;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class LoginPageTest extends BaseTest {

    protected ResetPasswordPage resetPasswordPage;

    @BeforeMethod
    public void methodSetup() {
        driver.get(baseURL);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test(priority = 0, enabled = true)
    public void emptyLogin() {

        loginPage.doLogin("","");

        List<String> actualErrors = loginPage.getLoginErrors();
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add("The email field is required.");
        expectedErrors.add("The password field is required.");

        Assert.assertEquals(actualErrors, expectedErrors);
    }

    @Test(priority = 1, enabled = true)
    public void unMatchedCredentialsLogin() {

        loginPage.doLogin(loginEmail,"123123");

        List<String> actualErrors = loginPage.getLoginErrors();
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add("These credentials do not match our records.");

        Assert.assertEquals(actualErrors, expectedErrors);
    }

    @Test(priority = 2)
    public void loginWithValidCredentials() {

        loginPage.doLogin(loginEmail,loginPassword);

        // Verify that Dashboard is visible
        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        String dashboardURL = driver.getCurrentUrl();
        dashboardPage.userAvatarRibbon.doLogout();
        Assert.assertEquals(dashboardURL, "https://zodha3.wavo.co/home");
    }


    @Test(priority = 3, enabled = true)
    public void forgotPasswordLink() {

        loginPage.initiateForgotPassword();

        Assert.assertEquals(driver.getCurrentUrl(), "https://zodha3.wavo.co/password/reset");

    }


    @Test(priority = 4, enabled = true)
    public void resetPasswordWithEmptyEmail() {
        loginPage.initiateForgotPassword();
        resetPasswordPage = PageFactory.initElements(driver, ResetPasswordPage.class);
        resetPasswordPage.doCompleteResetPassword("");

        Assert.assertEquals(resetPasswordPage.getErrorMessage(), "The email field is required.");
    }

    @Test(priority = 5, enabled = true)
    public void resetPasswordWithNonExistingEmail() {
        loginPage.initiateForgotPassword();
        resetPasswordPage = PageFactory.initElements(driver, ResetPasswordPage.class);
        resetPasswordPage.doCompleteResetPassword("non-exist@me.com");
        Assert.assertEquals(resetPasswordPage.getErrorMessage(), "We can't find a user with that e-mail address.");
    }

    @Test(priority = 6, enabled = true)
    public void resetPasswordWithValidEmail() {
        loginPage.initiateForgotPassword();
        resetPasswordPage = PageFactory.initElements(driver, ResetPasswordPage.class);
        resetPasswordPage.doCompleteResetPassword("madhoo@zodha.com");
        Assert.assertEquals(resetPasswordPage.getSuccessMessage(), "We have e-mailed your password reset link!");
    }

}
