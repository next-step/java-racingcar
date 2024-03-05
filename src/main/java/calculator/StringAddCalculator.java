package calculator;

public class StringAddCalculator {
    public static int splitAndSum(final String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        return convertStringToInt(s);
    }

    private static int convertStringToInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            throw new RuntimeException();
        }
    }
}
