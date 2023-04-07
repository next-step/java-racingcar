package calculator;

public class Calculator {

    public static final int ZERO = 0;

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return ZERO;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        return 0;
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
