package org.example.src;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResetPasswordPage {

    protected WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "div.panel-body > h2")
    protected WebElement forgotPasswordTitle;

    @FindBy(css = "input[name='email']")
    protected WebElement emailID;

    @FindBy(css = "button.btn.btn-primary.btn-block")
    protected WebElement resetPasswordButton;

    @FindBy(css = "div[data-plugin='formMaterial'] > span")
    protected WebElement emailFieldError;

    @FindBy(css = "div[class='alert alert-success text-left']")
    protected WebElement emailSentSuccessMessage;

    public String getFormTitle() {
        return forgotPasswordTitle.getText();
    }

    public String getErrorMessage() {
        WebDriverWait wdWait = new WebDriverWait(driver, 10);
        wdWait.until(ExpectedConditions.visibilityOf(emailFieldError));
        return emailFieldError.getText();
    }

    public String getSuccessMessage() {
        WebDriverWait wdWait = new WebDriverWait(driver, 10);
        wdWait.until(ExpectedConditions.visibilityOf(emailSentSuccessMessage));
        return emailSentSuccessMessage.getText();
    }

    public void doCompleteResetPassword(String email) {
        emailID.sendKeys(email);
        resetPasswordButton.click();
    }


}
