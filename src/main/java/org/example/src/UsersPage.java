package org.example.src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class UsersPage extends BasePage {

    @FindBy(css = "h1.page-title.text-capitalize")
    protected WebElement pageHeader;

    @FindBy(css = "button[data-target='#sendInvitationModal']")
    protected WebElement addUserButton;

    @FindBy(css = "div.swal-modal > div:nth-child(3)")
    protected WebElement invitationSuccessMessage;

    @FindBy(css = "div.swal-modal > div.swal-title")
    protected WebElement updateSuccessMessage;


    @FindBy(id = "exampleModalLabel")
    protected WebElement dialogHeader;

    @FindBy(css = "#sendInvitationModal>div div.modal-body > div:first-child > input")
    protected WebElement emailIdField;

    @FindBy(css = "#sendInvitationModal button.btn-primary")
    protected WebElement sendButton;

    @FindBy(css = "#updateInviteRoleModal button.btn.btn-primary")
    protected WebElement updateButton;

    @FindBy(css = "div.panel-body > div:nth-child(2) > div > div > div")
    protected List<WebElement> invitedUsers;

    protected final String eachUserEmailContentCssSelector = "div:first-child > h4.m-0.text-truncate";
    protected final String eachUserEditButtonCssSelector = "div:last-child > button:first-child";
    protected final String eachUserCancelButtonCssSelector = "div:last-child > button:last-child";

    @FindBy(css = "button.swal-button.swal-button--confirm.swal-button--danger")
    protected WebElement yesButtonOnWarningDialog;

    protected final String confirmationModelSuccessIconCssSelector = "div.swal-icon.swal-icon--success";

    @FindBy(css = "div.swal-modal > div.swal-text")
    protected WebElement confirmationMessage;

    @FindBy(css = "div.swal-button-container > button")
    protected WebElement okButtonOnconfirmationModel;

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    public void addUser(String emailID, boolean canViewCampaign, boolean canCreateCampaign,
                        boolean canExport, boolean canViewLISearch, boolean canCreateLISearch) {

        addUserButton.click();
        emailIdField.sendKeys(emailID);
        pause(2);
        updatePermissions(canViewCampaign, canCreateCampaign, canExport, canViewLISearch, canCreateLISearch, true);

        sendButton.click();
    }

    private void updatePermissions(boolean canViewCampaign, boolean canCreateCampaign, boolean canExport,
                                   boolean canViewLISearch, boolean canCreateLISearch, boolean sendInvitation) {

        String allowUser2ViewCampaignsCheckBoxSelector;
        String allowUser2CreateAndEditCampaignsCheckBoxSelector;
        String allowUser2ExportDataCheckBoxSelector;
        String allowUser2UseLinkedInSearchsCheckBoxSelector;
        String allowUser2CreateAndEditLinkedInSearchsCheckBoxSelector;

        if (sendInvitation) {
            allowUser2ViewCampaignsCheckBoxSelector = "userInviteRoleView";
            allowUser2CreateAndEditCampaignsCheckBoxSelector = "userInviteRoleEdit";
            allowUser2ExportDataCheckBoxSelector = "userInviteRoleExport";
            allowUser2UseLinkedInSearchsCheckBoxSelector = "userInviteLinkedinRoleRead";
            allowUser2CreateAndEditLinkedInSearchsCheckBoxSelector = "userInviteLinkedinRoleEdit";
        } else {
            allowUser2ViewCampaignsCheckBoxSelector = "inviteCampaignRoleView";
            allowUser2CreateAndEditCampaignsCheckBoxSelector = "inviteCampaignRoleEdit";
            allowUser2ExportDataCheckBoxSelector = "inviteCampaignRoleExport";
            allowUser2UseLinkedInSearchsCheckBoxSelector = "inviteLinkedinRoleRead";
            allowUser2CreateAndEditLinkedInSearchsCheckBoxSelector = "inviteLinkedinRoleEdit";
        }

        WebElement allowUser2ViewCampaignsCheckBox = driver.findElement(By.id((allowUser2ViewCampaignsCheckBoxSelector)));
        WebElement allowUser2CreateAndEditCampaignsCheckBox = driver.findElement(By.id((allowUser2CreateAndEditCampaignsCheckBoxSelector)));
        WebElement allowUser2ExportDataCheckBox = driver.findElement(By.id((allowUser2ExportDataCheckBoxSelector)));
        WebElement allowUser2UseLinkedInSearchsCheckBox = driver.findElement(By.id((allowUser2UseLinkedInSearchsCheckBoxSelector)));
        WebElement allowUser2CreateAndEditLinkedInSearchsCheckBox = driver.findElement(By.id((allowUser2CreateAndEditLinkedInSearchsCheckBoxSelector)));

        pause(1);
        if (canViewCampaign != allowUser2ViewCampaignsCheckBox.isSelected()) {
            allowUser2ViewCampaignsCheckBox.click();
        }

        pause(1);
        if (canCreateCampaign != allowUser2CreateAndEditCampaignsCheckBox.isSelected()) {
            allowUser2CreateAndEditCampaignsCheckBox.click();
        }
        pause(1);
        if (canExport != allowUser2ExportDataCheckBox.isSelected()) {
            allowUser2ExportDataCheckBox.click();
        }
        pause(1);
        if (canViewLISearch != allowUser2UseLinkedInSearchsCheckBox.isSelected()) {
            allowUser2UseLinkedInSearchsCheckBox.click();
        }
        pause(1);
        if (canCreateLISearch != allowUser2CreateAndEditLinkedInSearchsCheckBox.isSelected()) {
            allowUser2CreateAndEditLinkedInSearchsCheckBox.click();
        }
    }


    public String getInvitationSuccessMessage() {
        waitForVisibilityOfAllElementsByCss("div.swal-modal > div:nth-child(3)");
        return invitationSuccessMessage.getText();
    }

    public boolean editUser(String email, boolean canViewCampaign, boolean canCreateCampaign,
                            boolean canExport, boolean canViewLISearch, boolean canCreateLISearch) {

        for (WebElement currentUser : invitedUsers) {

            WebElement currentInvitedUserEmail = currentUser.findElement(By.cssSelector(eachUserEmailContentCssSelector));

            if (currentInvitedUserEmail.getAttribute("innerText").contains(email)) {
                // click on edit button of this user
                WebElement editButton = currentUser.findElement(By.cssSelector(eachUserEditButtonCssSelector));
                editButton.click();
                updatePermissions(canViewCampaign, canCreateCampaign, canExport, canViewLISearch, canCreateLISearch, false);
                updateButton.click();

                return true;
            }
        }
        return false;
    }

    public boolean cancelUser(String email) {

        for (WebElement currentUser : invitedUsers) {

            WebElement currentInvitedUserEmail = currentUser.findElement(By.cssSelector(eachUserEmailContentCssSelector));

            if (currentInvitedUserEmail.getAttribute("innerText").contains(email)) {
                // click on cancel button of this user
                WebElement cancelButton = currentUser.findElement(By.cssSelector(eachUserCancelButtonCssSelector));
                //scrollIntoView(currentUser);
                cancelButton.click();
                return true;
            }
        }
        return false;
    }



    public void confirmCancel() {
        yesButtonOnWarningDialog.click();
    }

    public String getSendConfirmationMessage() {

        waitForVisibilityOfAllElementsByCss(confirmationModelSuccessIconCssSelector);

        return confirmationMessage.getText();
    }

    public String getUpdateConfirmationMessage() {

        waitForVisibilityOfAllElementsByCss(confirmationModelSuccessIconCssSelector);

        return updateSuccessMessage.getText();
    }



    public void closeConfirmationModel() {
        okButtonOnconfirmationModel.click();
    }
}
