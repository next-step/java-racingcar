package calculator;

public class StringAddCalculator {
    public static int splitAndSum(final String input) {
        if (isEmpty(input)) {
            return 0;
        }

        return -1;
    }

    private static boolean isEmpty(final String input) {
        return input == null || input.isEmpty();
    }
}
