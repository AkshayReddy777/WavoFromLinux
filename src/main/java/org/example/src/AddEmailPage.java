package org.example.src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddEmailPage extends BasePage{

    @FindBy(css = "div>input.form-control")
    protected List<WebElement> fieldOptions;

    @FindBy(css = "ul.dropdown-menu.inner>li")
    protected List<WebElement> client;

    @FindBy(css = "div.pt-20.text-center>button")
    protected WebElement addEmailAccount;


    public AddEmailPage(WebDriver driver){
        super(driver);
    }

    public void addEmail(String firstname, String lastname, String email, String password, String client){
        WebElement firstnameField = fieldOptions.get(0);
        firstnameField.sendKeys(firstname);

        WebElement lastnameField = fieldOptions.get(1);
        lastnameField.sendKeys(lastname);

        WebElement emailField = fieldOptions.get(2);
        emailField.sendKeys(email);

        WebElement passwordField = fieldOptions.get(3);
        passwordField.sendKeys(password);

        Select option = new Select(driver.findElement(By.cssSelector("div.btn-group.bootstrap-select.form-control>select")));
        option.selectByVisibleText(client);


        addEmailAccount.click();



    }

}
