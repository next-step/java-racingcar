package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (isEmptyString(input)) {
            return 0;
        }

        return sum(split(input));
    }

    private static boolean isEmptyString(String str) {
        return str == null || str.isEmpty();
    }

    private static List<Integer> split(String str) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(str);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return toInts(matcher.group(2).split(customDelimiter));
        }

        return toInts(str.split(DEFAULT_DELIMITER));
    }

    private static List<Integer> toInts(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < values.length; ++i) {
            numbers.add(parseToPositive(values[i]));
        }

        return numbers;
    }

    private static int parseToPositive(String number) {
        int result = parseToInteger(number);
        if (result < 0) {
            throw new RuntimeException("0 이상의 숫자만 포함되어야 합니다.");
        }

        return result;
    }

    private static int parseToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자로 변환할수 없는 문자열입니다.");
        }
    }

    private static int sum(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }

        return result;
    }
}
