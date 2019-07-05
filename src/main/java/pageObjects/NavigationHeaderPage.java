package pageObjects;

public class NavigationHeaderPage extends Page {

    private static final String SEARCH_FIELD_LOCATOR = "searchInput";
    private static final String OPTION = "css=a[title='%s']";
    private static final String SEARCH_BUTTON = "css=#searchButton";

    public void setSearchField(String search) {
        driverWrapper().sendKeys(SEARCH_FIELD_LOCATOR, search);
    }

    public void selectOption(String search) {
        driverWrapper().click(String.format(OPTION, search));
    }

    public void clickSearchButton() {
        driverWrapper().click(SEARCH_BUTTON);
    }
}
