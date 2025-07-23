package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextAreaHelper {
    public static void write(WebDriver driver, String label, String text) {
        driver.findElement(By.xpath(String.format("//label[text() = \"%s\"]/parent::lightning-textarea//textarea", label))).sendKeys(text);
    }
}
