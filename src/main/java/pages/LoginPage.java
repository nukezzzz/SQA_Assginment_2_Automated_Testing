package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

import base.TestBase;
import utils.Log;

public class LoginPage extends TestBase {

    //Page Factory - Object Repository
    @FindBy(xpath = "//div[@class='atLogoImg']")
    WebElement actiTimeLogo;

    @FindBy(xpath = "//span[@class='errormsg']")
    WebElement errorMsg;
    
    @FindBy(xpath = "//input[@name='username']")
    @CacheLookup
    WebElement userName;

    @FindBy(xpath = "//input[@type='password'and @name='pwd']")
    WebElement passWord;

    @FindBy(xpath = "//a[@id='loginButton']")
    WebElement loginButton;



    //initialization
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Action/Methods
    public Boolean validateActiTimeLogo() {
        return actiTimeLogo.isDisplayed();
    }

    public HomePage login(String username, String password){
        userName.sendKeys(username);
        passWord.sendKeys(password);
        loginButton.click();
        return new HomePage();
    }

    public void successful_login() {
        userName.sendKeys(properties.getProperty("correct_username"));
        passWord.sendKeys(properties.getProperty("correct_password"));
        loginButton.click();
    }
    public void unsuccessful_login() {
        userName.sendKeys(properties.getProperty("wrong_username"));
        passWord.sendKeys(properties.getProperty("wrong_password"));
        loginButton.click();
    }

    public Boolean validateErrorMsg() {
        return errorMsg.isDisplayed();
    }
}
