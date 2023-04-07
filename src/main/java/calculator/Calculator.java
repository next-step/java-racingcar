package calculator;

public class Calculator {

    public static final int ZERO = 0;
    public static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return ZERO;
        }

        return sum(parse(split(input)));
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    private static int[] parse(String[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }

        return result;
    }

    private static int sum(int[] numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
