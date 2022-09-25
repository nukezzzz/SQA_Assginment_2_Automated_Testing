package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaveTrackPage extends TestBase {
    String employee = properties.getProperty("employee");
    String reason = properties.getProperty("reason");

    //Page Factory - Object Repository
    @FindBy(xpath = "//a[@class='item'][.='View Time-Track']")
    WebElement viewLeaveTrack;

    @FindBy(xpath = "//td[@class='viewTimeTrackTitle pagetitle']/span")
    WebElement viewTitle;

    @FindBy(xpath = "//div[@class='userNameWrapper']//span[@class='dashedLink']")
    WebElement timeDropdown;

    @FindBy(xpath = "//span[@class='userName'][.='White, Jane']")
    WebElement selectTime;

    @FindBy(xpath = "//div[@class='userNameWrapper']//span[@class='dashedLink'][.='White, Jane']")
    WebElement viewDetails;



    //initialization
    public LeaveTrackPage() {
        PageFactory.initElements(driver, this);
    }

    //Action/Methods
    public void viewLeaveTrack() {
    	viewLeaveTrack.click();
    }

    public Boolean validateviewTitle() {
        return viewTitle.isDisplayed();
    }

    public void clicktimeDropdown() {
        timeDropdown.click();
    }

    public void selectTime(String name) {
    	selectTime.click();
    }

    public Boolean validateDetails() {
        return viewDetails.isDisplayed();
    }


}
