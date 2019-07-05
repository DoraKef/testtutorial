package base;

import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    public SoftAssert softAssert;
    public WebDriver driver;

    @BeforeTest
    public void initializeDriver() {
        softAssert = new SoftAssert();
        driver = DriverManager.createDriver();
    }

    @AfterMethod
    public void shutdownDriver() {
        DriverManager.closeDriver();
    }

    @AfterTest
    public void close() {
        softAssert.assertAll();
    }
}
