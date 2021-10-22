package org.example.src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsPage {

    protected WebDriver chrome;
    protected UserNavigationRibbon userNavigationRibbon;
    @FindBy(css = "a[href=\"/reports/campaign-aggregates\"]")
    protected WebElement aggregateReport;
    @FindBy (css = "a[href=\"/reports/date-range\"]")
    protected WebElement dateRangeReport;

    public ReportsPage(WebDriver driver) {
        chrome = driver;
    }

    public void clickOnAggregateReports(){

        aggregateReport.click();
    }
    public void clickOnDateRangeReports(){

        dateRangeReport.click();
    }


}
