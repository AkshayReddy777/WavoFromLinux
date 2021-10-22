package org.example.src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingPage {

        protected WebDriver chrome;
        @FindBy(name = "name")
        protected WebElement userName;
        @FindBy(xpath = "//*[@id=\"profile\"]/div/div[2]/div[2]/form/div[3]/button")
        protected WebElement submitButton;

        public SettingPage(WebDriver driver) {
            chrome = driver;
        }
        public void changeUserName() throws InterruptedException {
            Thread.sleep(1000);
            System.out.println(userName.getAttribute("value").toString());
            if(userName.getAttribute("value").contains("madhoo")) {
                System.out.println("into the if condition");
                userName.clear();
                userName.sendKeys("MadhooBandi");
                submitButton.click();
            }
            if(userName.getAttribute("value").contains("MadhooBandi")) {
                userName.clear();
                userName.sendKeys("madhoo");
                submitButton.click();
            }
            System.out.println("text");
        }
    }
