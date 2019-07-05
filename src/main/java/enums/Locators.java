package enums;

public enum Locators {

    CSS_SELECTOR("css"),
    XPATH_SELECTOR("xpath"),
    XPATH_SELECTOR_QUERY("//"),
    NAME_SELECTOR("name"),
    CLASSNAME_SELECTOR("className"),
    TAGNAME_SELECTOR("tagName"),
    PARTIAL_LINK_SELECTOR("partialLink");

    private String locator;

    Locators(String locator) {
        this.locator = locator;
    }

    public String get() {
        return locator;
    }
}
