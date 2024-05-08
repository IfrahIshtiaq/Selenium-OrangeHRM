package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.LoginPage;
import pageobject.RecruitmentPage;

public class RecruitmentTest extends BaseTest{

    @BeforeClass()
    public void loginUser(){
        LoginPage login = new LoginPage(driver);
        login.login(properties.getProperty("valid-username"), properties.getProperty("valid-password"));
    }
    @Test(description = "Add a new candidate", priority = 1)
    public void addNewCandidate(){
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.clickRecruitmentButton();
        recruitmentPage.clickCandidatesTab();
        recruitmentPage.clickAddButton();

        // Assert that we are on Add Candidate page
        String candidateHeader_expected = "Add Candidate";
        Assert.assertEquals(recruitmentPage.candidateHeader_actual(), candidateHeader_expected);

        recruitmentPage.addCandidate(properties.getProperty("valid-username"), properties.getProperty("invalid-password"));

    }
    @Test(description = "Add a new Vacancy", priority = 2)
    public void addNewVacancy() throws InterruptedException {
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.clickRecruitmentButton();
        recruitmentPage.clickVacanciesTab();
        recruitmentPage.clickAddButton();

        // Assert that we are on Add Vacancy page
        String vacancyHeader_expected = "Add Vacancy";
        Assert.assertEquals(recruitmentPage.vacancyHeader_actual(), vacancyHeader_expected);

        recruitmentPage.addVacancy(properties.getProperty("vacancy_name"), properties.getProperty("hiring_manager"));
    }

    @Test(description = "View Candidate", priority = 3)
    public void viewCandidate(){
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.clickRecruitmentButton();
        recruitmentPage.viewCandidate();

        // Assert that the Candidate Profile is opened
//        String candidateProfileHeader_expected = "Candidate Profile";
//        Assert.assertEquals(recruitmentPage.candidateProfileHeader_actual(), candidateProfileHeader_expected);
    }

}
