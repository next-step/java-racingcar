package calculator;

public class Calculator {

    public static final int ZERO = 0;
    public static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return ZERO;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        int result = ZERO;
        String[] numbers = input.split(DEFAULT_DELIMITER);

        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
