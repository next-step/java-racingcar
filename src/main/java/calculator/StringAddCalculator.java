package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^-?\\d+$");
    private static final int DELIMITER_GROUP_INDEX = 1;
    private static final int INPUT_GROUP_INDEX = 2;

    private StringAddCalculator() {
        throw new UnsupportedOperationException("유틸 클래스의 인스턴스를 생성할 수 없습니다.");
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private static String[] split(String delimiter, String str) {
        return str.split(delimiter);
    }

    private static void validatePositiveIntegerFromString(String str) {
        if (!INTEGER_PATTERN.matcher(str).matches()) {
            throw new RuntimeException("숫자만 입력가능하지만 입력받은 문자열은 " + str + "입니다!");
        }
        if (Integer.parseInt(str) <= 0) {
            throw new RuntimeException("양수만 입력가능하지만 입력받은 문자열은 " + str + "입니다!");
        }
    }

    private static int sum(String[] numbers){
        int result = 0;
        for (String number : numbers) {
            validatePositiveIntegerFromString(number);
            result += Integer.parseInt(number);
        }
        return result;
    }

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        Matcher customDelimiter = CUSTOM_DELIMITER.matcher(input);
        if (customDelimiter.find()) {
            delimiter = customDelimiter.group(DELIMITER_GROUP_INDEX);
            input = customDelimiter.group(INPUT_GROUP_INDEX);
        }

        String[] numbers = split(delimiter, input);
        return sum(numbers);
    }
}
