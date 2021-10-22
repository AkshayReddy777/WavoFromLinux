package org.example.src;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ClientsPage extends BasePage {

    @FindBy(css = "h1.page-title")
    protected WebElement pageHeader;

    @FindBy(css = "a[href='/clients/create']")
    protected WebElement addClientButton;

    @FindBy(css = "div[class^='card card-shadow']")
    protected List<WebElement> clientsList;

    @FindBy(name = "name")
    protected WebElement clientNameField;

    @FindBy(name = "max_emails")
    protected WebElement maximumEmailsForClient;

    @FindBy(css = "button.btn.btn-primary")
    protected WebElement addClientSubmitButton;

    @FindBy(css = "a>i.icon.wb-users")
    protected WebElement usersButton;


    public ClientsPage(WebDriver driver) {
        super(driver);
    }

    public void addClient(String name, String maxEmails) {
        addClientButton.click();
        pause(1);
        clientNameField.sendKeys(name);
        maximumEmailsForClient.clear();
        maximumEmailsForClient.sendKeys(maxEmails);
        addClientSubmitButton.click();
    }

    public int getExistingClientsCount() {
        int count = 0;
        try {
            count = clientsList.size();
        } catch(Exception ex) {
            System.out.println("Users list is empty.");
        }
        return count;
    }

    public void goToUsers() {
        usersButton.click();
    }

}
