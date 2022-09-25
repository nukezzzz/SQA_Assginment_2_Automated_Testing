package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage extends TestBase {

    // Web Element Xpath
    @FindBy(xpath = "//div[.='Reports']/parent::a")
    WebElement GetreportLink;

    @FindBy(xpath = "//div[@class=\"config-name\"][contains(text(), 'Leaves')]")
    WebElement clickUserLeaveCard;

    @FindBy(xpath = "//div[@class=\"reportName\"][contains(text(), 'Leaves')]")
    WebElement viewUserLeaveReport;

    //initialization
    public ReportsPage() {
        PageFactory.initElements(driver, this);
    }

    //Action/Methods
    public void reportsClick() {
    	GetreportLink.click();
    }

    public void leaveTabClick() {
    	clickUserLeaveCard.click();
    }

    public Boolean validateview() {
        return viewUserLeaveReport.isDisplayed();
    }

}
