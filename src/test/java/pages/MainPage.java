package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Contract/home");
        waitPageLoad();
    }

    public void clickContact() {
        driver.findElement(By.xpath("//*[@data-key=\"add\"]")).click();
        driver.findElement(By.xpath("//a[@title=\"New Contact\"]")).click();
    }

    public void clickToastLink() {
        waitPageLoad();
        driver.findElement(By.xpath("//div[contains(@class, \"toastContainer\")]//a")).click();
    }
}
