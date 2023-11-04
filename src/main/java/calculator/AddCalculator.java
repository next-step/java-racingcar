package calculator;

import static calculator.StringSpliter.getIntArray;
import static calculator.StringSpliter.getSplittedString;

public class AddCalculator {
    private static final int ZERO = 0;

    private AddCalculator() {
    }

    public static int getSum(String input) {
        if (isEmpty(input)) {
            return ZERO;
        }
        String[] splittedString = getSplittedString(input);
        int[] intArray = getIntArray(splittedString);
        return sum(intArray);
    }

    static boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }

    private static int sum(int[] numbers) {
        int result = ZERO;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
