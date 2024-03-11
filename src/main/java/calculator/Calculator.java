package calculator;

public class Calculator {
    private static final int ZERO = 0;
    public static final String DELIMITER = ",|:";

    public static int calculate(String input) {
        if (isBlank(input)) {
            return ZERO;
        }
        return sum(split(input));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static String[] split(String input) {
        String[] values = input.split(DELIMITER);
        return values;
    }

    private static int sum(String[] values) {
        int result = ZERO;
        for (String value : values) {
            result += toInt(value);
        }
        return result;
    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
