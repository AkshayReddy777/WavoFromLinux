package org.example.src;

import TestUtils.BOUserLoginCreds;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
// whatsup
// Added this comment
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected String baseURL;
    protected String loginEmail;
    protected String loginPassword;
    public static final String BS_USERNAME = "meghnavijay_HwSiVX";
    public static final String BS_AUTOMATE_KEY = "eFyptq4BHy3SLPn9pG9V";
    public static final String BS_URL = "https://" + BS_USERNAME + ":" + BS_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static final String SL_URL = "https://oauth-meghnavjy-ec611:64030293-ca27-4d95-a0d8-b6cffd0d254f@ondemand.us-west-1.saucelabs.com:443/wd/hub";
    public static final String LT_username = "meghnavjy";
    public static final String LT_accessKey = "bMWb7DL5GzqUeL6vKP3ynvus0qx8aG96ixUswsrvNnM51ln3FN";
    public static final String LT_URL = "https://"+LT_username+":"+LT_accessKey+"@hub.lambdatest.com/wd/hub";



    @BeforeTest
    public void setupForTest() {
        System.out.println("This is BaseTest's BeforeClass.");
//        WebDriverManager.chromedriver().setup();
    }

    @Parameters ("where")
    @BeforeClass
    public void setupForEveryTestClass(String where) throws MalformedURLException {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setHeadless(true);
//        chromeOptions.addArguments("start-maximized");
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
//
//        driver = new ChromeDriver();


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setVersion("latest");
        if (where.equals("BS")) {
            driver = new RemoteWebDriver(new URL(BS_URL), caps);
        }else if (where.equals("SL")) {
            driver = new RemoteWebDriver(new URL(SL_URL), caps);
        }else if (where.equals("LT")) {
            driver = new RemoteWebDriver(new URL(LT_URL), caps);
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        BOUserLoginCreds.initialize();
        loginEmail = BOUserLoginCreds.getEmail();
        loginPassword = BOUserLoginCreds.getPassword();
        baseURL = BOUserLoginCreds.getBaseURL();

        driver.get(baseURL);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @AfterClass
    public void closeClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


}
