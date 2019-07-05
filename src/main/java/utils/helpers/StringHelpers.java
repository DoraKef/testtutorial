package utils.helpers;

public class StringHelpers {

    public static boolean isNull(String value) {
        return value == null;
    }

    public static boolean isWhitespace(String value) {
        return value.equals("");
    }

    public static String retrieveValueAfterEquals(String locator) {
        return locator.substring(locator.indexOf("=") + 1);
    }
}
