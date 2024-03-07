package step2_string_calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlusCalculator {
    private static final String STANDARD_REGEX = ":|,";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final int CUSTOM_DELIMITER_GROUP = 1;
    public static final int NUMBERS_GROUP = 2;

    public static int splitAndSum(String text) {

        if (isNullOrEmpty(text)) return 0;
        String[] string = getParsedStringNumbers(text);
        int[] numbers = stringToIntOrThrowException(string);
        validateNegativeNumber(numbers);
        return getSum(numbers);
    }

    private static void validateNegativeNumber(int[] numbers) {
        Arrays.stream(numbers).forEach(
                value -> {
                    if (value < 0) throw new RuntimeException("input은 음수가 될 수 없습니다");
                }
        );
    }

    private static int getSum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static String[] getParsedStringNumbers(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (matcher.find()) {
            String customOperator = matcher.group(CUSTOM_DELIMITER_GROUP);
            String numbers = matcher.group(NUMBERS_GROUP);
            return numbers.split(customOperator);
        }
        return text.split(STANDARD_REGEX);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int[] stringToIntOrThrowException(String[] processed) {
        return Arrays.stream(processed).mapToInt(Integer::parseInt).toArray();
    }
}
