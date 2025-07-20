package wrappers;

import entity.InputType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputHelper {
    public static void write(WebDriver driver, String label, String text, InputType type) {
        switch (type) {
            case Account -> writeAccount(driver, label, text);
            case ModalContact -> writeContact(driver, label, text);
        }
    }

    public static void writeAccount(WebDriver driver, String label, String text) {
        driver.findElement(By.xpath(String.format("//label[text() = \"%s\"]//parent::div/descendant::input", label))).sendKeys(text);
    }

    public static void writeContact(WebDriver driver, String label, String text) {
        driver.findElement(By.xpath(String.format("//label/span[text() = \"%s\"]/ancestor::label/following-sibling::input", label))).sendKeys(text);
    }
}
