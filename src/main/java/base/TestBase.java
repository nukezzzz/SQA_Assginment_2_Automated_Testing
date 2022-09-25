package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utils.Log;
import utils.TestUtil;
import utils.WebEventListener;

public class TestBase {
    public static WebDriver driver;
    public static Properties properties;
    
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase() {
//        DOMConfigurator.configure("log4j.xml");
//        Log.startTestCase("Selenium_Test Cases");

        try {
            properties = new Properties();
            FileInputStream iprop = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
            properties.load(iprop);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = properties.getProperty("target_browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "F:\\uni\\assingment\\data_folder\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(properties.getProperty("website"));
    }
}
