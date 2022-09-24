package step2;

public class StringAddCalculator {
    private static final int EMPTY_VALUE = 0;

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return EMPTY_VALUE;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        String[] strNumbers = input.split(",");

        return -1;
    }

    private static boolean isBlank(String value) {
        return value == null || value.isEmpty() ? true : false;
    }

    private static boolean hasCustomDelimiter(String value) {
        return true;
    }

    private static String extractDelimiter(String value) {
        return "";
    }

}
