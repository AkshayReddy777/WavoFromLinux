package org.example.src;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import TestUtils.GenerateData;

public class UsersPageTest extends BaseTest {

    protected DashboardPage dashboardPage;
    protected ClientsPage clientsPage;
    protected UsersPage usersPage;

    @BeforeClass
    public void usersPageTestClassSetup() {
        loginPage.doLogin(loginEmail, loginPassword);
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.closeCustomerlyNotifications();

        dashboardPage.userNavigationRibbon.goTo("Clients");

        clientsPage = PageFactory.initElements(driver, ClientsPage.class);
        if(clientsPage.getExistingClientsCount() == 0) {
            clientsPage.addClient("Baba", "99");
        }
        clientsPage.goToUsers();
        usersPage = PageFactory.initElements(driver, UsersPage.class);
    }


    @Test(priority = 0, description = "Sending invitation to user")
    public void inviteUserTest() {


        usersPage.addUser(GenerateData.getCurrentRandomEmailID(), true,
                true, false, false, false);

        String expected = "An invitation was sent to " + GenerateData.getCurrentRandomEmailID();
        Assert.assertEquals(usersPage.getInvitationSuccessMessage(), expected);
        usersPage.closeConfirmationModel();
        usersPage.refresh();
    }

    @Test(priority = 1)
    public void editUserTest() {

        usersPage.editUser(GenerateData.getCurrentRandomEmailID(), true,
                        false, true, true, true);

        Assert.assertEquals(usersPage.getUpdateConfirmationMessage(), "Permissions Updated");
        usersPage.closeConfirmationModel();
    }

    @Test(priority = 2)
    public void cancelUserTest() {

        if(usersPage.cancelUser(GenerateData.getCurrentRandomEmailID())) {
            usersPage.confirmCancel();
        }
        Assert.assertEquals(usersPage.getSendConfirmationMessage(),
                "An invitation to " + GenerateData.getCurrentRandomEmailID() + " was cancelled");
        usersPage.closeConfirmationModel();
    }

}
