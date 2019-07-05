package searchOperation;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.EncyclopaediaPage;
import pageObjects.NavigationHeaderPage;

public class SearchOperationHappyPathTest extends BaseTest {

    @Test
    public void searchOperationSuccessfully() {
        NavigationHeaderPage navigationHeaderPage = new NavigationHeaderPage();
        navigationHeaderPage.setSearchField("Requests for comment/JSON validation");
        navigationHeaderPage.selectOption("Requests for comment/JSON validation");

        EncyclopaediaPage encyclopaediaPage = new EncyclopaediaPage();
        Boolean isInCorrectPage = encyclopaediaPage.validateIfCorrectPage("Requests for comment/JSON validation");
        Assert.assertTrue(isInCorrectPage);
    }
}
