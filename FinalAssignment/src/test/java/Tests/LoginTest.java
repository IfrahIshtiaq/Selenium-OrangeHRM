package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.LoginPage;

public class LoginTest extends BaseTest{
    @Test(description = "Verifying user can login successfully with valid username and valid password", priority = 3)
    public void loginValidUsernamePassword(){
        LoginPage login = new LoginPage(driver);
        login.login(properties.getProperty("valid-username"), properties.getProperty("valid-password"));

        // Assert that the Login is successful
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, properties.getProperty("expected_URL_after_login"));
    }

    @Test(description = "Verifying user can not login successfully with invalid username and valid password", priority = 1)
    public void  loginInvalidUsername(){
        LoginPage login = new LoginPage(driver);
        login.login(properties.getProperty("invalid-username"), properties.getProperty("valid-password"));

        // Assert that the Invalid credentials error message is displayed
        Assert.assertTrue(login.errorMessage().isDisplayed(), "Invalid credentials message displayed.");
    }

    @Test(description = "Verifying user can not login successfully with valid username and invalid password", priority = 2)
    public void  loginInvalidPassword(){
        LoginPage login = new LoginPage(driver);
        login.login(properties.getProperty("valid-username"), properties.getProperty("invalid-password"));

        // Assert that the Invalid credentials error message is displayed
        Assert.assertTrue(login.errorMessage().isDisplayed(), "Invalid credentials message displayed.");
    }
}
