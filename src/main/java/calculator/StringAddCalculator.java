package calculator;

public class StringAddCalculator {
    public static int splitAndSum(final String input) {
        if (isEmpty(input)) {
            return 0;
        }

        return sum(split(input));
    }

    private static String[] split(final String input) {
        return input.split("[,|:]");
    }

    private static int sum(final String[] numbers) {
        int sum = 0;

        for (final String number : numbers) {
            final int eachValue = Integer.parseInt(number);

            if (eachValue < 0) {
                throw new RuntimeException("Input must be a positive integer");
            }

            sum += eachValue;
        }

        return sum;
    }

    private static boolean isEmpty(final String input) {
        return input == null || input.isEmpty();
    }
}
