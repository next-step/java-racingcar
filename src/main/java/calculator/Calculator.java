package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final String DEFAULT_DELIMITER_REGEX = "[:,]";

    public static int calculate(String targetString) {
        if (isNullOfEmpty(targetString)) {
            return 0;
        }

        return hasCustomDelimiter(targetString)
                ? calculateWithCustomDelimiter(targetString)
                : calculateWithDefaultDelimiter(targetString);
    }

    private static int calculateWithDefaultDelimiter(String targetString) {
        if (hasDefaultDelimiter(targetString)) {
            String[] tokens = targetString.split(DEFAULT_DELIMITER_REGEX);
            return sumTokens(tokens);
        }
        return Integer.parseInt(targetString); // 구분자 없이 단일 숫자일 때
    }

    private static int calculateWithCustomDelimiter(String targetString) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(targetString);
        if (m.find()) {
            String customDelimiter = Pattern.quote(m.group(1));
            String[] tokens = m.group(2).split(customDelimiter);
            return sumTokens(tokens);
        }
        return 0;
    }

    private static boolean hasCustomDelimiter(String targetString) {
        return Pattern.matches("//(.)\n(.*)", targetString);
    }

    private static boolean isNullOfEmpty(String targetString) {
        return targetString == null || targetString.isEmpty();
    }

    private static int sumTokens(String[] tokens) {
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
