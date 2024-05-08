package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class PIMPage extends BaseClass{
//    WebDriver driver;
    Properties properties;

    // Locators on PIM Page
    By PIM_button = new By.ByXPath("//span[text()='PIM']"); //PIM button on left menu pane
    By addEmployee_button = new By.ByXPath("//li/a[contains(text(), 'Add Employee')]"); //Add Employee button
    By firstname = new By.ByName("firstName"); //First Name
    By lastname = new By.ByName("lastName"); //Last Name
    By save_button = new By.ByCssSelector("[type=submit]"); //Save Button
    By employeeList_button = new By.ByXPath("//li/a[contains(text(), 'Employee List')]"); //Employee List button
    By enterEmployeeName = new By.ByXPath("//div[@class='oxd-table-filter']//input"); //Enter Employee Name field
    By search_button = new By.ByXPath("//button[@type='submit']"); //Search Button


    public PIMPage(WebDriver driver){
        this.driver=driver;
    }

    // Method to click on the PIM button
    public void clickPIMButton() {
        driver.findElement(PIM_button).click();
    }

    // Method to click on the Add Employee tab
    public void clickAddEmployee() {
        driver.findElement(addEmployee_button).click();
    }

    // Method to click on the Employee List tab
    public void clickEmployeeList() {
        driver.findElement(employeeList_button).click();
    }

    // Add Employee method
    public void addEmployee(String firstname, String lastname){
        driver.findElement(this.firstname).sendKeys(firstname);
        driver.findElement(this.lastname).sendKeys(lastname);
        driver.findElement(this.save_button).click();
    }

    // Search Employee Method
    public void searchEmployee(String firstname, String lastname){
        driver.findElement(this.enterEmployeeName).sendKeys(firstname + ' ' + lastname);
        driver.findElement(this.search_button).click();
    }

    public WebElement newCandidate(){
        return driver.findElement(By.xpath("//div/h6[@class ='oxd-text oxd-text--h6 --strong']"));
    }

    public String getCandidateText(){
        return this.newCandidate().getText();
    }



}
