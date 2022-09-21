package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        String[] numbers = split(text);
        return sum(numbers);
    }

    private static String[] split(String text) {
        String[] numbers = text.split("[,:]");

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            numbers = matcher.group(2).split(customDelimiter);
        }

        return numbers;
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int parsedInt = Integer.parseInt(number);
            validateNegative(parsedInt);
            sum += parsedInt;
        }
        return sum;
    }

    private static void validateNegative(int parsedInt) {
        if (parsedInt < 0) {
            throw new RuntimeException("음수가 입력되었습니다");
        }
    }
}
