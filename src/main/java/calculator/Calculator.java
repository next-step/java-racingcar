package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String NEGATIVE_INTEGER_ERROR_MESSAGE = "음수를 입력할 수 없습니다.";

    public static int sum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        return stringToSum(input);
    }

    private static int stringToSum(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (m.find()) {
            return stringTosum(m.group(2), m.group(1));
        }
        return stringTosum(input, DEFAULT_DELIMITER_REGEX);
    }

    private static int stringTosum(String input, String delimiter) {
        String[] split = input.split(delimiter);
        for (var element : split) {
            if (element.charAt(0) == '-') {
                throw new RuntimeException(NEGATIVE_INTEGER_ERROR_MESSAGE);
            }
        }
        return Arrays.stream(input.split(delimiter))
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
