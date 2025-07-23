package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage{

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void getToDetails() {
        driver.findElement(By.xpath("//a[@id = \"detailTab__item\"]")).click();
        waitPageLoad();
    }

    public String getName() {
        return driver.findElement(
                By.xpath(
                        String.format(
                                "//records-record-layout-item[@field-label = \"Name\"]//lightning-formatted-name")
                )
        ).getText();
    }

    public void closeToast() {
        waitPageLoad();
        driver.findElement(By.xpath("    //div[contains(@class, \"toastContainer\")]//button[contains(@class, \"toastClose\")]")).click();
    }
}
