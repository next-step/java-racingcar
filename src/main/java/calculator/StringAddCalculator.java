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
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private static boolean isEmpty(final String input) {
        return input == null || input.isEmpty();
    }
}
