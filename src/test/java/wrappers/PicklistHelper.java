package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Picklist {
    public static void select(WebDriver driver, String label, String option) {
        driver.findElement(By.xpath(String.format("//label[text() = \"label\"]//parent::div/descendant::button", label))).click();
        
    }
}
