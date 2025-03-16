package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(REGEX);

    public static int toInt(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }

    public static int calculate(String input) {
        if (isBlankInput(input)) return 0;
        return sum(toInts(splitNumbers(input)));
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static int[] toInts(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(num -> {
            int number = toInt(num);
            validateNegativeNumber(number);
            return number;
        }).toArray();
    }

    private static void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 허용되지 않습니다.");
        }
    }

    private static boolean isBlankInput(String input) {
        return input == null || input.isBlank();
    }

    private static String[] splitNumbers(String input) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }
}
