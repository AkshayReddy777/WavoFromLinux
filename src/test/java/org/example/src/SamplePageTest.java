package org.example.src;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SamplePageTest  {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver;

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setHeadless(true);
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);



        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://zodha.wavo.co/login");

        Thread.sleep(2000);

        WebElement emailElement = driver.findElement(By.name("email"));
        WebElement passwordElement = driver.findElement(By.name("password"));
        WebElement signInButtonElement = driver.findElement(By.cssSelector("button[type='submit']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value = arguments[1]", emailElement);
        jse.executeScript("arguments[0].value = '123123Aa@'", passwordElement);
        jse.executeScript("arguments[0].click()", signInButtonElement);

        Thread.sleep(2000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenShotFile = screenshot.getScreenshotAs(OutputType.FILE);


        File DestFile = new File("E:\\QA Auto-8th Batch\\3. JavaPrograms\\SampleProject\\ScreenShots\\1.jpg");

        //Copy file at destination

        FileUtils.copyFile(screenShotFile, DestFile);



    }

}
