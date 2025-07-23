package pages;

import entity.AccountRating;
import entity.InputType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.CheckboxHelper;
import wrappers.InputHelper;
import wrappers.PicklistHelper;
import wrappers.TextAreaHelper;

public class NewAccountPage extends BasePage {
    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    public void createAccount(String name, String phone, AccountRating rating, boolean isVip, String description) {
        InputHelper.write(driver, "Account Name", name, InputType.Account);
        InputHelper.write(driver, "Phone", phone, InputType.Account);
        PicklistHelper.select(driver, "Rating", rating.toString(), InputType.Account);
        if (isVip) {
            CheckboxHelper.check(driver, "VIP Client");
        }
        TextAreaHelper.write(driver, "Description", description);
        save();
    }

    public void open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        waitPageLoad();
    }

    public void save() {
        driver.findElement(By.xpath("//button[text() = \"Save\"]")).click();
    }
}
