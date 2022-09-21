package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String PATTERN = "//(.)\n(.*)";
    private static final String COMMA_OR_COLON = ",|:";

    public static int splitAndSum(String input) {
        if (validate(input)) {
            return 0;
        }
        return sum(split(input));
    }

    private static boolean validate(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher matcher = Pattern.compile(PATTERN).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(COMMA_OR_COLON);
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(StringAddCalculator::parsePositiveInt).sum();
    }

    private static int parsePositiveInt(String input) {
        int number = Integer.parseInt(input);
        if (isNegative(number)){
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }

}
