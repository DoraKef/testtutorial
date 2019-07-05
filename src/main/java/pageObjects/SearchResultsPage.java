package pageObjects;

public class SearchResultsPage extends Page {

    private static final String PAGE_TITLE = "firstHeading";
    private static final String OPTION = "css=a[title='%s']";
    private static final String SEARCH_RESULTS = "Search results";
    private static final String NO_RESULT = "css=p.mw-search-nonefound";

    public void selectResult(String title) {
        driverWrapper().click(String.format(OPTION, title));
    }

    public Boolean validateIfCorrectPage() {
        String elementText = driverWrapper().getText(PAGE_TITLE);
        return SEARCH_RESULTS.equals(elementText);
    }

    public Boolean resultNotFound() {
        return driverWrapper().findElement(NO_RESULT).isDisplayed();
    }
}
