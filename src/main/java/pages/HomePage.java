package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    //Page Factory - Object Repository
    @FindBy(xpath = "//a[@class='content tasks']")
    WebElement taskLink;

    @FindBy(xpath = "//a[@class='content reports']")
    WebElement reportsLink;

    @FindBy(xpath = "//div[@id='logo_aT']")
    WebElement actitimeLogo;

    //initialization
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //Action/Methods -Executed by other pages
    public Boolean validateActiTimeLogo() {
        return actitimeLogo.isDisplayed();
    }

    public ReportsPage clickOnReportsLink() {
        reportsLink.click();
        return new ReportsPage();
    }
}
