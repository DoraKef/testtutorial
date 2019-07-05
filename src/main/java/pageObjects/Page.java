package pageObjects;

import drivers.DriverManager;
import drivers.DriverWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    public WebDriver driver() {
        return DriverManager.getDriver();
    }

    public WebDriverWait webDriverWait() { return DriverManager.getWait(); }

    public WebDriverWait webDriverWait(long timeout) { return new WebDriverWait(DriverManager.getDriver(), timeout); }

    public DriverWrapper driverWrapper() {
        return DriverManager.getDriverWrapper();
    }
}
