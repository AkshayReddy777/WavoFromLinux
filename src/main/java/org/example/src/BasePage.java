package org.example.src;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected WebDriverWait wdWait;
    protected TakesScreenshot takesScreenshot;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        jse = (JavascriptExecutor) driver;
        takesScreenshot = (TakesScreenshot) driver;
        wdWait = new WebDriverWait(driver, 10);
    }

    public void waitForVisibilityOfAllElementsByCss(String cssSelector) {
        wdWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssSelector)));
    }

    public void waitForElementToBeClickable(WebElement elm) {
        wdWait.until(ExpectedConditions.elementToBeClickable(elm));
    }

    public void clikOnWebElement(WebElement elm) {
        elm.click();
    }

    public void sendKeysToElement(WebElement elm, String data) {
        elm.sendKeys(data);
    }

    public void scrollIntoView(WebElement elm) {
        jse.executeScript("arguments[0].scrollIntoView()", elm);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch(InterruptedException ex) {
            System.out.println("Interrupted while sleeping.");
        }
    }

}
