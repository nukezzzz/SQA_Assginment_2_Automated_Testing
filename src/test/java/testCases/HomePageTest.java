package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(properties.getProperty("correct_username"), properties.getProperty("correct_password"));
    }

    @Test(priority = 1, testName = "Test - Validate the log is visible in the Home page")
    public void homePageLogoTest() {
        boolean flag = homePage.validateActiTimeLogo();
        Assert.assertTrue(flag, " Test - logo is unable to find in the Home page");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
