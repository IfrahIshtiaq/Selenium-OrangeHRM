package Tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.LoginPage;
import pageobject.PIMPage;

public class PIMTest extends BaseTest{

    @BeforeClass()
    public void loginUser(){
        LoginPage login = new LoginPage(driver);
        login.login(properties.getProperty("valid-username"), properties.getProperty("valid-password"));
    }

    @Test(description = "Verifying user can add an employee", priority = 1)
    public void addEmployee() throws InterruptedException{
        PIMPage pimpage = new PIMPage(driver);
        pimpage.clickPIMButton();
        pimpage.clickAddEmployee();
        String abc = properties.getProperty("firstname");
        pimpage.addEmployee(properties.getProperty("firstname"), properties.getProperty("lastname"));

        Thread.sleep(8000);

        // Assert that the new user is added
        Assert.assertTrue(pimpage.newCandidate().isDisplayed());
        Assert.assertEquals(pimpage.getCandidateText(),properties.getProperty("firstname") + ' ' + properties.getProperty("lastname"));
    }

    @Test(description = "Search an existing employee", priority = 2)
    public void searchValidEmployee(){
        PIMPage pimpage = new PIMPage(driver);
        pimpage.clickEmployeeList();
        pimpage.searchEmployee(properties.getProperty("firstname"), properties.getProperty("lastname"));
    }

    @Test(description = "Search a non-existing employee", priority = 3)
    public void searchInvalidEmployee(){
        PIMPage pimpage = new PIMPage(driver);
        pimpage.clickEmployeeList();
        pimpage.searchEmployee(properties.getProperty("invalid-username"), " ");
    }

}
