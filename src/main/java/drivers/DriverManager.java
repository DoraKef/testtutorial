package drivers;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverManager {

    private static final String CONFIG_FILE = "config/config.properties";
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverManager.class);

    private static WebDriver driver;

    public static WebDriver createDriver() {
        Properties properties = getProperties();

        DriverType driverType = DriverType.getDriverType(properties.getProperty("driverType"));
        driver = DriverFactory.createDriver(driverType);

        String url = properties.getProperty("baseUrl") + properties.getProperty("branchUrl");
        driver.get(url);

        return driver;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        InputStream stream = ClassLoader.getSystemResourceAsStream(CONFIG_FILE);

        try {
            properties.load(stream);
        } catch (IOException ex) {
            LOGGER.error("Cannot load the file: " + ex);
        }

        return properties;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        LOGGER.info("The driver is closed");
    }
}
