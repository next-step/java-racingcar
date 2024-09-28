package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final String CUSTOM_DELIMITER_CHECK_REGEX = "//(.)\n(.*)";
    public static final String DEFAULT_DELIMITER_CHECK_REGEX = "[:,]";

    public static int calculate(String targetString) {
        if (isNullOfEmpty(targetString)) {
            return 0;
        }

        if (hasCustomDelimiter(targetString)) {
            Matcher m = Pattern.compile(CUSTOM_DELIMITER_CHECK_REGEX).matcher(targetString);
            if (m.find()) {
                String customDelimiter = Pattern.quote(m.group(1));
                String[] tokens = m.group(2).split(customDelimiter);
                return loopAndAdd(tokens);
            }
        }

        if (hasDefaultDelimiter(targetString)) {
            String[] tokens = targetString.split(DEFAULT_DELIMITER_CHECK_REGEX);
            return loopAndAdd(tokens);
        }
        return Integer.parseInt(targetString);
    }

    private static boolean hasCustomDelimiter(String targetString) {
        return Pattern.matches("//(.)\n(.*)", targetString);
    }

    private static boolean isNullOfEmpty(String targetString) {
        return targetString == null || targetString.isEmpty();
    }

    private static int loopAndAdd(String[] tokens) {
        int result = 0;
        for (String addNumber : tokens) {
            validate(addNumber);
            result += Integer.parseInt(addNumber);
        }
        return result;
    }

    private static boolean hasDefaultDelimiter(String targetString) {
        return targetString.contains(",") || targetString.contains(":");
    }

    private static void validate(String targetString) {
        try {
            int number = Integer.parseInt(targetString);
            validateMinus(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값입니다.");
        }
    }

    private static void validateMinus(int targetNumber) {
        if (targetNumber < 0) {
            throw new RuntimeException("연산 대상 숫자가 음수입니다.");
        }
    }
}
