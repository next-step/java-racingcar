package calculator;

public class Calculator {
    private static final int ZERO = 0;

    public static int calculate(String input) {
        if (isBlank(input)) {
            return ZERO;
        }
        return toInt(input);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
