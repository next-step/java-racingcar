package study;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int blankNumber(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }

        throw new IllegalArgumentException("처리할 수 없는 text입니다.");
    }

    public static int ChangeInteger(String text) {
        validateNotNegative(text);
        return Integer.parseInt(text);
    }

    public static int splitAndSum(String text) {
        if (text.contains(",") || text.contains(":")) {
            int sum = 0;
            String[] numbers = text.split("[,:]");

            for (String number : numbers) {
                validateNotNegative(number);

                sum += Integer.parseInt(number);
            }

            return sum;
        }

        throw new IllegalArgumentException("처리할 수 없는 text입니다.");
    }

    public static int customSplitAndSum (String text){

        if (text.contains("//") || text.contains("\n")) {
            int sum = 0;
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
            if (m.find()) {

                String customDelimiter = m.group(1);
                String[] tokens = m.group(2).split(customDelimiter);

                for (String token : tokens) {
                    sum += Integer.parseInt(token);
                }

                return sum;
            }
        }
        throw new IllegalArgumentException("처리할 수 없는 text입니다,");
    }

    public static void validateNotNegative(String text) {
        if(Integer.parseInt(text) < 0) {
            throw new RuntimeException(" RuntimeException 예외 발생");
        }
    }

}