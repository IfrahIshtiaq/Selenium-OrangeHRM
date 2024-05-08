package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utils.UtilsConfig;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    Properties properties;

    protected static WebDriver driver; // Make the WebDriver instance static
    @BeforeTest
    public void  setup() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        properties = UtilsConfig.getProperties("test");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(properties.getProperty("URL")); // using properties file
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
