package org.example.src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserNavigationRibbon {

   protected WebDriver driver;

   @FindBy(css = "ul.site-menu > li > a")
   List<WebElement> navigationOptions;


   public UserNavigationRibbon(WebDriver driver) {
       this.driver = driver;
   }

   public void goTo(String option) {
       for (WebElement currentOption : navigationOptions) {
           WebElement textElm = currentOption.findElement(By.cssSelector("span"));
           if (textElm.getText().equalsIgnoreCase(option)) {
               currentOption.click();
               break;
           }
       }
   }

    public void goToSpecificReports(String reportChoiceName) {
        WebElement reportsElement = navigationOptions.get(6);
        reportsElement.click();

        WebElement requiredReportElm = null;

        if (reportChoiceName.equalsIgnoreCase("Aggregate Report")) {
            requiredReportElm = driver.findElement(By.cssSelector("ul.site-menu-sub.site-menu-normal-list > li:first-child > a"));
        } else if (reportChoiceName.equalsIgnoreCase("Date Range Report")) {
            requiredReportElm = driver.findElement(By.cssSelector("ul.site-menu-sub.site-menu-normal-list > li:last-child > a"));
        }

        if(requiredReportElm != null) {
            requiredReportElm.click();
        }
    }



}
