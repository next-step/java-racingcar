package calculator;

import static common.ObjectUtils.isEmpty;
import static common.StringSpliter.getIntArray;
import static common.StringSpliter.getSplittedString;

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


    private static int sum(int[] numbers) {
        int result = ZERO;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
