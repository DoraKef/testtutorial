package pageObjects;

public class EncyclopaediaPage extends Page {

    private static final String INFO_BOX_TEXT = "css=[class='tpl-infobox-header'] > th span";

    public Boolean validateIfCorrectPage(String search) {
        String infoBoxText = driverWrapper().findElement(INFO_BOX_TEXT).getText();
        return search.contains(infoBoxText);
    }
}
