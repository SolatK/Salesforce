package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitPageLoad() {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        final JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        final ExpectedCondition<Boolean> jQueryActive_toBeZero = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return (Long) jsExecutor
                            .executeScript("return jQuery.active") == 0;
                } catch (final WebDriverException e) {
                    return true; //skip the wait
                }
            }
        };
        final ExpectedCondition<Boolean> document_readyState_toBeComplete = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        wait.until(jQueryActive_toBeZero);
        wait.until(document_readyState_toBeComplete);
        synchronized (wait) {
            try {
                wait.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
