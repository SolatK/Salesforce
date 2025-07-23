package tests;

import entity.AccountRating;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.NewAccountPage;

import java.time.LocalDateTime;

public class AccountTest extends BaseTest {

    @Test
    public void createAccountTest() {

        LoginPage login = new LoginPage(driver);
        login.open();
        login.login();


        NewAccountPage newAccount = new NewAccountPage(driver);
        newAccount.open();
        String name = String.format("Тестов Тестович %tT", LocalDateTime.now());
        String phone = String.format("89%09d", (int) (999999999 * Math.random()));
        boolean isVip = Math.random() > 0.5;
        String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed fringilla dui sed scelerisque venenatis. Donec mollis mauris ac dictum gravida. Maecenas feugiat vitae massa a condimentum. Integer tincidunt quam a rhoncus varius.";
        AccountRating rating = AccountRating.HOT;
        newAccount.waitPageLoad();
        newAccount.createAccount(name, phone, rating, isVip, description);

        AccountPage accountPage = new AccountPage(driver);
        accountPage.closeToast();
        accountPage.getToDetails();

        Assert.assertEquals(accountPage.getDetail("Account Name"), name);
        Assert.assertEquals(accountPage.getPhone(), phone);
        Assert.assertEquals(accountPage.getDetail("Description"), description);
        accountPage.getCheckbox("VIP Client");
    }
}
