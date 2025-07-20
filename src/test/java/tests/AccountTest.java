import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class AccountTest {

    @Test
    public void checkCreateAccount() throws InterruptedException {
        WebDriver driver = getDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tms9-dev-ed.develop.my.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("tborodich@tms.sandbox");
        driver.findElement(By.id("password")).sendKeys("Password003!");
        driver.findElement(By.id("Login")).click();

        //todo заменить нормальным ожиданием
        sleep(5000);
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");

        driver.findElement(By.xpath("//input[@name=\"Name\"]")).sendKeys("test");
    }

    private static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");

        return new ChromeDriver(options);
    }
}
