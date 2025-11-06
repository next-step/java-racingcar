package study.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public static int calculate(String input) {
        if (checkNullOrEmpty(input)) {
            return 0;
        }

        String[] numbers = split(input);
        int[] parseNumbers = parseStringToInteger(numbers);

        return sum(parseNumbers);
    }

    private static boolean checkNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(input);

        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }

        return input.split(SEPARATOR);
    }

    private static int[] parseStringToInteger(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(StringCalculator::parseStringToInt)
                .toArray();
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static int parseStringToInt(String value) {
        int number = Integer.parseInt(value);
        validatePositive(number);
        return number;
    }

    private static void validatePositive(int number) {
        if (checkNegativeNumber(number)) {
            throw new RuntimeException("0보다 작은 수는 입력할 수 없습니다.");
        }
    }

    private static boolean checkNegativeNumber(int number) {
        return number < 0;
    }


}
