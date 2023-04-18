package racing.util;

public class StringUtil {

    private static final String DEFAULT_DELIMITER = ",";

    public static String[] split(String textInput) {
        return textInput.split(DEFAULT_DELIMITER);
    }

    public static String join(String[] textInput) {
        return String.join(DEFAULT_DELIMITER + " ", textInput);
    }

}
