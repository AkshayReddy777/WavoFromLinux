package org.example.src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UserAvatarRibbon {

    protected WebDriver driver;

    @FindBy(css = "div.navbar-header > a > span > img:first-child")
    protected WebElement logoIcon;

    @FindBy(css = "img[alt='...']")
    protected WebElement userAvatarIcon;

    @FindBy(css = "a[href='/settings']")
    protected WebElement settingOption;

    @FindBy(css = "a[href='/logout']")
    protected WebElement logOutOption;

    @FindBy(css = "i.icon.wb-bell")
    protected WebElement alertsIcon;

    @FindBy(css = "div#site-navbar-collapse > ul > li:last-child > div > div")
    protected List<WebElement> notificationsList;

    public UserAvatarRibbon(WebDriver driver) {
        this.driver = driver;
    }

    public String getBackgroundColorAsHexCode() {
        WebElement navBar = driver.findElement(By.cssSelector("nav[role='navigation']"));
        String colorRGBA = navBar.getCssValue("background-color");

        return Color.fromString(colorRGBA).asHex();
    }

    public void goToSettingsPage() {
        userAvatarIcon.click();
        settingOption.click();
    }

    public void doLogout() {
        userAvatarIcon.click();
        logOutOption.click();
    }

    public String getNotificationsHeaderText() {
        WebElement headerElm = notificationsList.get(0);

        return headerElm.findElement(By.cssSelector("h5")).getText();
    }

    public boolean doesNotificationsExist() {
        alertsIcon.click();

        WebElement clearButtonElm = notificationsList.get(0).findElement(By.cssSelector("a"));
        String cssValue = clearButtonElm.getCssValue("style");
        if (cssValue.contains("none")) {
            return false;
        }
        return true;
    }

    public List<String> getActualNotifications() {

        if (doesNotificationsExist() == false) {
            return null;
        }

        List<String> notificationsAsStringList = new ArrayList<>();
        for(WebElement currentNotification:  notificationsList) {

        }

        return notificationsAsStringList;
    }


}
