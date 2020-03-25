package CarRacing.Utils;

public class StringUtils {
    static private final String EMPTY_STRING = "";

    private static void validateInputString(final String inputStr) {
        if (inputStr == null || inputStr.trim().equals(EMPTY_STRING)) {
            throw new IllegalArgumentException("Empty string not allowed in this function");
        }
    }

    public static String[] splitStringToStringArr(final String inputString) {
        validateInputString(inputString);
        return inputString.split(",");
    }
}
