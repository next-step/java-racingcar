package calculator;

public class StringAddCalculator {
    public static int splitAndSum(final String input) {
        if (isEmpty(input)) {
            return 0;
        }

        return sum(toInts(split(input)));
    }

    private static String[] split(final String input) {
        return input.split("[,|:]");
    }

    private static int sum(final int[] numbers) {
        int sum = 0;

        for (final int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static int[] toInts(final String[] numbers) {
        int[] intNumbers = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            final int parseInt = Integer.parseInt(numbers[i]);

            if (parseInt < 0) {
                throw new RuntimeException("Input must be a positive integer");
            }

            intNumbers[i] = parseInt;
        }

        return intNumbers;
    }

    private static boolean isEmpty(final String input) {
        return input == null || input.isEmpty();
    }
}
