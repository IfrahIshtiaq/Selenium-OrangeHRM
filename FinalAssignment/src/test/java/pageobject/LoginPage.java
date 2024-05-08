package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class LoginPage extends BaseClass{
    // WebDriver driver;
    Properties properties;
    // Locators

    By username = new By.ByName("username");
    By password = new By.ByName("password");
    By login_button = new By.ByCssSelector("[type=submit]");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    // Login method
    public void login(String username, String password){
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.login_button).click();
    }

    public WebElement errorMessage(){
        return driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/p[1]"));
    }

}
