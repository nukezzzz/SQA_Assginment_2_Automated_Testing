package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LeaveTrackPage;
import pages.LoginPage;

public class LeaveTrackPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    LeaveTrackPage leaveTrackPage;

    public LeaveTrackPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(properties.getProperty("correct_username"), properties.getProperty("correct_password"));
        leaveTrackPage = new LeaveTrackPage();
    }

    @Test(testName = "Review leaves of an employee")
    public void viewTimeTrackDetails() {
    	leaveTrackPage.viewLeaveTrack();
    	leaveTrackPage.validateviewTitle();
    	leaveTrackPage.clicktimeDropdown();
    	leaveTrackPage.selectTime(properties.getProperty("member"));
    	leaveTrackPage.validateDetails();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
