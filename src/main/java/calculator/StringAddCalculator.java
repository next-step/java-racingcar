package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static String CUSTOM_PATTERN = "//(.)\n(.*)";
    private static String DEFAULT_PATTERN = ",|:";

    public static int splitAndSum(String input){
         if(input == null || input.isEmpty()) {
            return 0;
        }
        return calculate(input);
    }
    private static int calculate(String input) {
        int result = 0;
        String[] numbers = split(input);
         for(String number : numbers) {
            result += parseNumber(number);
        }
        return result;
    }
    // 문자열 분리
    public static String[] split(String input) {

        Matcher m = Pattern.compile(CUSTOM_PATTERN).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }
        return input.split(DEFAULT_PATTERN);
    }
    public static int parseNumber(String input) {
        int number = Integer.parseInt(input);
        if(number < 0) {
            throw new RuntimeException("음수를 입력 할 수 없습니다. 입력값을 확인해주세요.");
        }
        return number;
    }
}
