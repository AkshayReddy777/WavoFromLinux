package org.example.src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignsPage extends BasePage {
    @FindBy (css = "div>a.btn.btn-outline.btn-primary.btn-round")
    protected WebElement createNewCampaignButton;

    @FindBy (css = "div>input.form-control")
    protected WebElement campaignNameField;

    @FindBy (css = "div>button.btn.btn-primary.float-right")
    protected WebElement createButton;

    @FindBy (css = "div>a.btn.mt-10.btn-default.d-block.w-120")
    protected WebElement editButton;

    @FindBy (css = "div>a.btn.btn-outline.btn-danger.btn-round")
    protected WebElement deleteButton;

    @FindBy (css = "p>button.btn.btn-danger")
    protected WebElement confirmDelete;

    @FindBy (css = "div>p.page-description.m-0.text-capitalize")
    protected WebElement title;




    public CampaignsPage(WebDriver driver){
        super(driver);
    }

    public void createCampaign(String campaignName){
        createNewCampaignButton.click();
        campaignNameField.sendKeys(campaignName);
        createButton.click();

    }

    public void deleteCampaign (String campaignName) {
        if (title.getText().equals(campaignName)) {
            editButton.click();
            deleteButton.click();
            confirmDelete.click();
        }
    }


}
