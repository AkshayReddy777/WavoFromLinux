package org.example.src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailAccountsPage extends BasePage{



    @FindBy(css = "span.text.hidden-sm-down")
    protected WebElement addButton;



    public EmailAccountsPage(WebDriver driver){
        super(driver);

    }

    public void gotoAddEmailPage(){
        waitForVisibilityOfAllElementsByCss("span.text.hidden-sm-down");
        addButton.click();


    }
}
