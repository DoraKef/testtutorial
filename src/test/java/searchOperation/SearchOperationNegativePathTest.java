package searchOperation;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NavigationHeaderPage;
import pageObjects.SearchResultsPage;

public class SearchOperationNegativePathTest {

    @Test
    public void searchOperationUnsuccessfully() {
        NavigationHeaderPage navigationHeaderPage = new NavigationHeaderPage();
        navigationHeaderPage.setSearchField("qwertyqwertyqwerty");
        navigationHeaderPage.clickSearchButton();

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Boolean isInSearchResultsPage = searchResultsPage.validateIfCorrectPage();
        Assert.assertTrue(isInSearchResultsPage);
        Boolean isResultFound = searchResultsPage.resultNotFound();
        Assert.assertTrue(isResultFound);
    }
}
