package pages;

import entity.AccountRating;
import org.openqa.selenium.WebDriver;
import wrappers.InputHelper;
import wrappers.PicklistHelper;

public class NewAccountModal extends BasePage {
    public NewAccountModal (WebDriver driver) {
        super(driver);
    }

    public void createAccount(String name, String phone, AccountRating rating) {
        InputHelper.write(driver, "Account Name", name);
        InputHelper.write(driver, "Phone", phone);
        PicklistHelper.select(driver, "Rating", rating.toString());
        //todo нажать создать
    }
}
