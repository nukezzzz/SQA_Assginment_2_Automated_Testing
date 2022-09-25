package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends TestBase {

    // Web Element Xpath
    @FindBy(xpath = "//div[.='Users']/parent::a")
    WebElement userTabLink;

    @FindBy(xpath = "//span[contains(text(), 'List of Users')]")
    WebElement userList;

    @FindBy(xpath = "//span[contains(text(), 'White, Jane')]/ancestor::tr[@class=contains(text(), 'userListRow linkedNotNull linkedWithActiplans')][1]")
    WebElement selectSpecifedUser;

    @FindBy(xpath = "//div[@class='header userPanel_panelHeader'][1]/div[.='Jane White']")
    WebElement userInfomation;

    //initialization
    public UsersPage() {
        PageFactory.initElements(driver, this);
    }

    //Action/Methods
    public void getToUsers() {
    	userTabLink.click();
    }

    public Boolean verifyUserView() {
        return  userList.isDisplayed();
    }

    public void clickUser() {
    	selectSpecifedUser.click();
    }


    public Boolean verifiyUserInformation() {
        return userInfomation.isDisplayed();
    }
}
