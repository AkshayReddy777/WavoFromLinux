package org.example.src;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    protected WebDriver driver;

    protected UserAvatarRibbon userAvatarRibbon;
    protected UserNavigationRibbon userNavigationRibbon;

    @FindBy(id = "customerly-notification-close-button")
    protected WebElement customerlyNoitificationCloseButton;


    public DashboardPage(WebDriver driver) {
        super(driver);

        userAvatarRibbon = PageFactory.initElements(driver, UserAvatarRibbon.class);
        userNavigationRibbon = PageFactory.initElements(driver, UserNavigationRibbon.class);
    }

    public void closeCustomerlyNotifications() {
        waitForVisibilityOfAllElementsByCss("#customerly-notification-close-button");
        clikOnWebElement(customerlyNoitificationCloseButton);
    }

}
