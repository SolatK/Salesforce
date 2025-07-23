package tests;

import entity.InputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.LoginPage;
import pages.MainPage;
import pages.NewContactModal;
import wrappers.PicklistHelper;

import java.time.LocalDateTime;

public class ContactTest extends BaseTest{

    @Test
    public void createContactTest() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login();

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickContact();

        NewContactModal newContact = new NewContactModal(driver);

        String name = String.format("Тестович %tT", LocalDateTime.now());
        String salutation = "Mr.";
        newContact.createNewContact(salutation, name);

        mainPage.clickToastLink();
        ContactPage contactPage = new ContactPage(driver);

        contactPage.closeToast();
        contactPage.getToDetails();
        Assert.assertEquals(contactPage.getName(), salutation + " " + name);
    }
}
