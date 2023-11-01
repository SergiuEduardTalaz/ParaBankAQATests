package Base;
import TestData.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class LoginBase {
    public static WebDriver driver;
    public String url = "https://parabank.parasoft.com/";

    @DataProvider(name = "valid-username")
    public Object[][] returnValidUsername() {
        return new Object[][] {
                { "Sergiu_Tester" },
        };
    }

    @DataProvider(name = "valid-account")
    public Object[][] returnValidAccount() {
        return new Object[][] {
                { new User("Sergiu_Tester", "Sergiutest1!", "https://parabank.parasoft.com/parabank/overview.htm") },
        };
    }

    @DataProvider(name = "inexistent-username")
    public Object [][] returnInvalidUsername(){
        return new Object[][]{
                { new User("valid_inexistent", "Sergiutest1!", "https://parabank.parasoft.com/", "An internal error has occurred and has been logged.") },
                { new User("ijvehfveaf", "Sergiutest1!", "https://parabank.parasoft.com/", "An internal error has occurred and has been logged.") },
                { new User("87650982", "Sergiutest1!", "https://parabank.parasoft.com/", "An internal error has occurred and has been logged.") },
                { new User("^@#$^@@^", "Sergiutest1!", "https://parabank.parasoft.com/", "An internal error has occurred and has been logged.") },
        };
    }

    @DataProvider(name = "empty-username")
    public Object [][] returnEmptyUsernames(){
        return new Object[][]{
                { new User("", "Sergiutest1!", "https://parabank.parasoft.com/", "Please enter a username and password.") }
        };
    }

    @BeforeMethod
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        final String driverChrome = "webdriver.chrome.driver";
        final String chromeDriverAddress = "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe";
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--no-sandbox");
        System.setProperty(driverChrome, chromeDriverAddress);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tests are completed, webdriver is closing.");
        driver.quit();
    }
}
