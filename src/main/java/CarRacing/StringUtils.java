package CarRacing;

public class StringUtils {
    static private final String BAR = "-";
    static private final String LINE_BREAK = "\n";
    static private final String EMPTY_STRING = "";

    private static void validateInputString(final String inputStr) {
        if (inputStr == null || inputStr.trim().equals(EMPTY_STRING)) {
            throw new IllegalArgumentException("Empty string not allowed in this function");
        }
    }

    public static String makeGauge(final int count) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(BAR);
        }

        sb.append(LINE_BREAK);
        return sb.toString();
    }

    public static String[] splitStringToStringArr(final String inputString) {
        validateInputString(inputString);
        return inputString.split(",");
    }
}
