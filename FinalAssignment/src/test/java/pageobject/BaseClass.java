package pageobject;
import org.openqa.selenium.WebDriver;

public class BaseClass {
    WebDriver driver;
    public String getURL(){
        return driver.getCurrentUrl();
    }
}
