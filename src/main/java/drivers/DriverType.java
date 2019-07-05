package drivers;

import org.openqa.selenium.WebDriverException;

import static utils.helpers.StringHelpers.isNull;
import static utils.helpers.StringHelpers.isWhitespace;

public enum DriverType {
    CHROME,
    FIREFOX;

    public static DriverType getDriverType(String browser) {

        if(isNull(browser) || isWhitespace(browser)) {
            throw new WebDriverException("The driver is unsupported");
        }

        switch (browser) {
            case "chrome":
                return CHROME;
            case "firefox":
                return FIREFOX;
            default:
                throw  new WebDriverException("The browser and the driver do not match");
        }
    }
}
