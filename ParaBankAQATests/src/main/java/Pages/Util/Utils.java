package Pages.Util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class Utils {
    public static FluentWait waitASpecificAmountOfTime(WebDriver driver, int totalWaitTime, int pollingTime) {
        return new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(totalWaitTime))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);
    }
}
