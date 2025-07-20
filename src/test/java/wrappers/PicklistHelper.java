package wrappers;

import entity.InputType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PicklistHelper {
    public static void select(WebDriver driver, String label, String option, InputType type) {
        switch (type) {
            case Account -> selectAccount(driver, label, option);
            case ModalContact -> selectContact(driver, label, option);
        }
    }

    private static void selectAccount(WebDriver driver, String label, String option) {
        driver.findElement(By.xpath(String.format("//label[text() = \"%s\"]//parent::div/descendant::button", label))).click();
        driver.findElement(By.xpath(String.format("//lightning-base-combobox-item//descendant::span[text() = \"%s\"]", option))).click();
    }

    private static void selectContact(WebDriver driver, String label, String option) {
        driver.findElement(By.xpath(String.format("//span[text() = \"%s\"]/ancestor::span/following-sibling::div//a", label))).click();
        driver.findElement(By.xpath(String.format("//li/a[text() = \"%s\"]", option))).click();
    }




}
