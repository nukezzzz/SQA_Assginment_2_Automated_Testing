package testCases;

import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;

public class UserPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    UsersPage userProfilePage;

    public UserPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(properties.getProperty("correct_username"), properties.getProperty("correct_password"));
        userProfilePage = new UsersPage();
    }

    @Test(testName = "View user datails defined in the properties")
    public void viewTimeTrackDetails() throws InterruptedException {
    	userProfilePage.getToUsers();
    	userProfilePage.verifyUserView();
    	userProfilePage.clickUser();
    	userProfilePage.verifiyUserInformation();
        Thread.sleep(2300);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
