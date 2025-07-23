package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void getToDetails() {
        driver.findElement(By.xpath("//a[@id = \"detailTab__item\"]")).click();
        waitPageLoad();
    }

    public void closeToast() {
        waitPageLoad();
        driver.findElement(By.xpath("    //div[contains(@class, \"toastContainer\")]//button[contains(@class, \"toastClose\")]")).click();
    }

    public String getDetail(String label) {
        return driver.findElement(
                By.xpath(
                        String.format(
                                "//records-record-layout-item[@field-label = \"%s\"]//lightning-formatted-text",
                                label)
                )
        ).getText();
    }

    public String getPhone() {
        return driver.findElement(By.xpath("//records-record-layout-item[@field-label = \"Phone\"]//a")).getText();
    }

    public boolean getCheckbox(String label) {
        String text = driver.findElement(
                By.xpath(
                        String.format("//records-record-layout-item[@field-label = \"%s\"]//lightning-input", label)
                )
        ).getAttribute("checked");
        return !Objects.isNull(text);
    }
}
