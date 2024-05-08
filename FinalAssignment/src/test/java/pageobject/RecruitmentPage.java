package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class RecruitmentPage extends BaseClass{

    Properties properties;

    // Locators

    By Recruitment_button = new By.ByXPath("//span[text()='Recruitment']"); // Recruitment button on left menu pane
    By candidates_tab = new By.ByXPath("//a[contains(text(),'Candidates')]"); // Candidates tab
    By vacancies_tab = new By.ByXPath("//a[contains(text(),'Vacancies')]"); // Vacancies tab
    By add_button = new By.ByXPath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]/i[1]"); // Add Button

    By candidate_firstname = new By.ByName("firstName"); //First Name
    By candidate_lastname = new By.ByName("lastName"); //Last Name
    // Email
    By vacancy_name = new By.ByXPath("//label[contains(text(),\"Vacancy Name\")]/../following-sibling::div/input"); // Vacancy Name
    By job_title_dd = new By.ByXPath("//i[contains(@class,'oxd-select-text--arrow')]"); // Job Title drop-down
    By job_title_value = new By.ByXPath("//div[@role='listbox']//*[contains(text(),'Account Assistant')]"); // Job Title drop-down value
//    By hiring_manager = new By.ByXPath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]"); //Hiring Manager
    By hiring_manager_dd = new By.ByXPath("//input[contains(@placeholder,'Type for hint')]"); //Hiring Manager
    By hiring_manager_value = new By.ByXPath("//div[@role='listbox']//*[contains(text(),'Rebecca')]"); //Hiring Manager


    By save_button = new By.ByCssSelector("[type=submit]"); //Save Button

    By viewIcon = new By.ByXPath("(//button/i[contains(@class, 'bi-eye-fill')])[1]"); //View Eye icon



    public RecruitmentPage(WebDriver driver){
        this.driver=driver;
    }

    // Method to click on the Candidates tab
    public void clickRecruitmentButton() {
        driver.findElement(Recruitment_button).click();
    }

    // Method to click on the Candidates tab
    public void clickCandidatesTab() {
        driver.findElement(candidates_tab).click();
    }

    // Method to click on the Vacancies tab
    public void clickVacanciesTab() {
        driver.findElement(vacancies_tab).click();
    }

    // Method to click on the Candidates tab
    public void clickAddButton() {
        driver.findElement(add_button).click();
    }

    // Add Candidate method
    public void addCandidate(String candidate_firstname, String candidate_lastname){
        driver.findElement(this.candidate_firstname).sendKeys(candidate_firstname);
        driver.findElement(this.candidate_lastname).sendKeys(candidate_lastname);
//        driver.findElement(this.login_button).click();
    }

    // Add Vacancy method
    public void addVacancy(String vacancy_name, String hiring_manager) throws InterruptedException {
        driver.findElement(this.vacancy_name).sendKeys(vacancy_name);
        driver.findElement(this.job_title_dd).click();
        driver.findElement(this.job_title_value).click();
        driver.findElement(this.hiring_manager_dd).click();
        driver.findElement(this.hiring_manager_dd).sendKeys(hiring_manager);
        Thread.sleep(3000);
        driver.findElement(this.hiring_manager_value).click();
        driver.findElement(this.save_button).click();
    }

    // View Candidate method
    public void viewCandidate() {
        driver.findElement(this.viewIcon).click();
    }

    public WebElement errorMessage(){
        return driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/p[1]"));
    }

    public String candidateHeader_actual(){
        return driver.findElements(By.tagName("h6")).get(1).getText();
    }

    public String vacancyHeader_actual(){
        return driver.findElements(By.tagName("h6")).get(1).getText();
    }

//    public String candidateProfileHeader_actual(){
//        return driver.findElements(new By.ByXPath("//h6[text()='Candidate Profile']")).getText();
//    }

}
