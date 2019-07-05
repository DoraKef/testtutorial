package drivers;

import enums.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static enums.Locators.CLASSNAME_SELECTOR;
import static enums.Locators.NAME_SELECTOR;
import static enums.Locators.PARTIAL_LINK_SELECTOR;
import static enums.Locators.TAGNAME_SELECTOR;
import static enums.Locators.XPATH_SELECTOR;
import static enums.Locators.XPATH_SELECTOR_QUERY;
import static utils.helpers.StringHelpers.retrieveValueAfterEquals;

public class DriverWrapper {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverWrapper.class);

    public DriverWrapper(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public By locate(String locatorString) {
        if(locatorString.startsWith(Locators.CSS_SELECTOR.get())) {
            return By.cssSelector(retrieveValueAfterEquals(locatorString));

        } else if(locatorString.startsWith(XPATH_SELECTOR.get())) {
            return By.xpath(retrieveValueAfterEquals(locatorString));

        } else if (locatorString.startsWith(XPATH_SELECTOR_QUERY.get())) {
            return By.xpath(retrieveValueAfterEquals(locatorString));

        } else if (locatorString.startsWith(NAME_SELECTOR.get())) {
            return By.name(retrieveValueAfterEquals(locatorString));

        } else if (locatorString.startsWith(CLASSNAME_SELECTOR.get())) {
            return By.className(retrieveValueAfterEquals(locatorString));

        } else if (locatorString.startsWith(TAGNAME_SELECTOR.get())) {
            return By.tagName(retrieveValueAfterEquals(locatorString));

        } else if (locatorString.startsWith(PARTIAL_LINK_SELECTOR.get())) {
            return By.partialLinkText(retrieveValueAfterEquals(locatorString));

        } else {
            return By.id(locatorString);
        }
    }

    public void click(String locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locate(locator)));
        element.click();
    }

    public void waitAndClick(String locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locate(locator)));
        element.click();
    }

    public void sendKeys(String locator, String text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locate(locator)));
        element.clear();
        element.sendKeys(text);
    }

    public void waitAndSendKeys(String locator, String text, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locate(locator)));
        element.clear();
        element.sendKeys(text);
    }
}
