package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import utils.TestUtil;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    String sheetName = "Users";
    TestUtil testUtil;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test(testName = "Validate logo is present in the Homepage", priority = 1)
    public void loginPageLogoTest() {
        boolean flag = loginPage.validateActiTimeLogo();
        Assert.assertTrue(flag);
    }

    @DataProvider
    public Object[][] getActiTimeTestData() {
        Object data[][] = testUtil.getTestData(sheetName);
        return data;
    }

    @Test(testName = "Successfull User validation with correct login data", priority = 2)
    public void validUserLoginTest() {
        loginPage.successful_login();
        homePage.validateActiTimeLogo();
    }

    @Test(testName = "Unsuccessfull User validation with incorrect login data", priority = 3)
    public void InvalidUserLoginTest() {
        loginPage.unsuccessful_login();
        loginPage.validateErrorMsg();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
