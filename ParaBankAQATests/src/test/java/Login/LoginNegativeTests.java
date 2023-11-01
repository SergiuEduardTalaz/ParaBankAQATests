package Login;

import Base.LoginBase;
import Pages.Login.LoginPage;
import TestData.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativeTests extends LoginBase {

    @Test(priority = 0, description = "TestNG: Test login with invalid usernames and valid password", dataProvider = "inexistent-username", dataProviderClass = LoginBase.class)
    public void testLoginFailureInvalidUsernames(User user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithUsernameAndPassword(user.getUsername(), user.getPassword());
        String actualErrorMessage = loginPage.returnLoginErrorMessage();

        Assert.assertEquals(driver.getCurrentUrl(), user.getExpectedUrl());
        Assert.assertEquals(actualErrorMessage, user.getExpectedErrorMessage());
    }

    @Test(priority = 1, description = "TestNG: Test login with empty username and valid password", dataProvider = "empty-username", dataProviderClass = LoginBase.class)
    public void testLoginFailureWithEmptySpaceUsername(User user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithUsernameAndPassword(user.getUsername(), user.getPassword());
        String actualErrorMessage = loginPage.returnLoginErrorMessage();

        Assert.assertEquals(driver.getCurrentUrl(), user.getExpectedUrl());
        Assert.assertEquals(actualErrorMessage, user.getExpectedErrorMessage());
    }
}