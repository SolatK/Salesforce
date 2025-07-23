package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxHelper {
    public static void check(WebDriver driver, String label) {
        driver.findElement(By.xpath(String.format("//label/span[text() = \"%s\"]//ancestor::lightning-primitive-input-checkbox//input", label))).click();
    }
}
