package drivers;

public class StringHelpers {

    public static boolean isNull(String value) {
        return value == null;
    }

    public static boolean isWhitespace(String value) {
        return value.equals("");
    }
}
