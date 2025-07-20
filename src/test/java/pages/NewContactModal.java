package pages;

import entity.InputType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.InputHelper;
import wrappers.PicklistHelper;

public class NewContactModal extends BasePage {

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    public void createNewContact(String salutation, String lastName) {
        PicklistHelper.select(driver, "Salutation", salutation, InputType.ModalContact);
        InputHelper.write(driver, "Last Name", lastName, InputType.ModalContact);
        clickSave();
    }

    public void clickSave() {
        driver.findElement(By.xpath("//button[contains(@class, \"slds-button--brand\")]/span[text() = \"Save\"]")).click();
    }
}
