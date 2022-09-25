package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.ReportsPage;
import pages.LoginPage;

public class ReportPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    ReportsPage reportsPage;

    public ReportPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(properties.getProperty("correct_username"), properties.getProperty("correct_password"));
        reportsPage = new ReportsPage();
    }

    @Test(testName = "View Leave Report for the user specifed")
    public void viewTimeTrackDetails() {
        reportsPage.reportsClick();
        reportsPage.leaveTabClick();
        reportsPage.validateview();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
