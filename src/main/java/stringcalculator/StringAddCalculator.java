package stringcalculator;

import java.util.Arrays;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_START_SIGN = "/";
    private static final String CUSTOM_DELIMITER_END_SIGN = "\n";

    public static int splitAndSum(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        String[] splitStr = split(str);

        return Arrays.stream(splitStr)
                .mapToInt(StringAddCalculator::convertStrToIntWithValid).sum();
    }

    private static String[] split(String str) {
        if (hasCustomDelimiter(str)) {
            return extractedExpression(str).split(customDelimiter(str));
        }
        return str.split(DEFAULT_DELIMITER_REGEX);
    }

    private static String extractedExpression(String expression) {
        int delimiterEndIndex = expression.indexOf(CUSTOM_DELIMITER_END_SIGN) + 1;
        return expression.substring(delimiterEndIndex);
    }

    private static boolean hasCustomDelimiter(String str) {
        return str.contains(CUSTOM_DELIMITER_START_SIGN) && str.contains(CUSTOM_DELIMITER_END_SIGN);
    }

    private static String customDelimiter(String str) {
        int delimiterStartIndex = str.lastIndexOf(CUSTOM_DELIMITER_START_SIGN) + 1;
        int delimiterEndIndex = str.indexOf(CUSTOM_DELIMITER_END_SIGN);
        return str.substring(delimiterStartIndex, delimiterEndIndex);
    }

    private static int convertStrToIntWithValid(String str) {
        try {
            int result = Integer.parseInt(str);
            if (result < 0) {
                throw new RuntimeException("음수입니다.");
            }
            return result;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
    }

}
