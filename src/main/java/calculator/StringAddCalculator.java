package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CUSTOM_PATTERN = "//(.)\n(.*)";
    private static final int CUSTOM_DELIMITER = 1;
    private static final int TARGET_PATTERN = 2;
    private static final String DEFAULT_PATTERN = ",|:";
    private static final String CAN_NOT_ENTER_NEGATIVE_NUMBER = "음수를 입력 할 수 없습니다. 입력값을 확인해주세요.";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return calculate(input);
    }

    private static int calculate(String input) {
        int result = 0;
        String[] numbers = split(input);
        for (String number : numbers) {
            result += parseNumber(number);
        }
        return result;
    }

    // 문자열 분리
    private static String[] split(String input) {

        Matcher m = Pattern.compile(CUSTOM_PATTERN).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER);
            String[] tokens = m.group(TARGET_PATTERN).split(customDelimiter);
            return tokens;
        }
        return input.split(DEFAULT_PATTERN);
    }

    // 형변환 & 음수 RuntimeException 처리
    private static int parseNumber(String input) {
        int singleNumber = Integer.parseInt(input);
        if (singleNumber < 0) {
            throw new RuntimeException(CAN_NOT_ENTER_NEGATIVE_NUMBER);
        }
        return singleNumber;
    }
}
