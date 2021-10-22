package org.example.src;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(name = "email")
    protected WebElement emailIDTextField;

    @FindBy(name = "password")
    protected WebElement passwordTextField;

    @FindBy(id = "inputCheckbox")
    protected WebElement rememberMeCheckBox;

    @FindBy(css = "a[href='https://zodha3.wavo.co/password/reset']")
    protected WebElement forgotPasswordLink;

    @FindBy(css = "button[type='submit']")
    protected WebElement signInButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void doLogin(String emailID, String password) {
        sendKeysToElement(emailIDTextField, emailID);
        sendKeysToElement(passwordTextField, password);

        clikOnWebElement(signInButton);
    }

    public void initiateForgotPassword() {
        waitForElementToBeClickable(forgotPasswordLink);
        forgotPasswordLink.click();
    }

    public boolean doesLogoExist() {

        WebElement logoParentElement = driver.findElement(By.cssSelector("div.panel.authbox > div.panel-body > div"));

        WebElement logoElement = null;
        try {
            logoElement = logoParentElement.findElement(By.tagName("img"));
        } catch(NoSuchElementException ex) {
            logoElement = logoParentElement.findElement(By.tagName("h2"));
        }

        return (logoElement != null);
    }

    public List<String> getLoginErrors() {
        String errorsCssSelector = "div.panel.authbox > div.panel-body > form > div:nth-child(1) > ul > li";
        waitForVisibilityOfAllElementsByCss(errorsCssSelector);

        List<WebElement> loginErrors = driver.findElements(By.cssSelector(errorsCssSelector));

        List<String> errorStrings = new ArrayList<>();

        for(WebElement elm : loginErrors) {
            errorStrings.add(elm.getText());
        }

        return errorStrings;
    }

}
