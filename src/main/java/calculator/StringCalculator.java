package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String REGEX = "//(.)\n(.*)";

    public static int toInt(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }

    public static int calculate(String input) {
        if (isEmptyInput(input)) return 0;
        return sum(toInts(splitNumbers(input)));
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int[] toInts(String[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = validateNegativeNumber(toInt(numbers[i]));
        }
        return result;
    }

    private static int validateNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 허용되지 않습니다.");
        }
        return number;
    }

    private static boolean isEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] splitNumbers(String input) {
        Matcher m = Pattern.compile(REGEX).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }
}
