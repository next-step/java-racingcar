package calculator;

public class StringAddCalculator {
    public static int splitAndSum(final String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        final String[] strings = s.split(",");

        int sum = 0;
        for (final String value : strings) {
            sum += convertStringToInt(value);
        }
        return sum;
    }

    private static int convertStringToInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            throw new RuntimeException();
        }
    }
}
