package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String givenValue) {
        if (isNullOrEmpty(givenValue)) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(givenValue);
        if (m.find()) {
            String[] numbers = splitByGivenDelimiter(m.group(2), m.group(1));
            return getTotal(numbers);
        }
        String[] numbers = splitByGivenDelimiter(givenValue, ",|:");
        return getTotal(numbers);
    }

    private static boolean isNullOrEmpty(String givenValue) {
        return givenValue == null || givenValue.isEmpty();
    }

    private static String[] splitByGivenDelimiter(String givenString, String customDelimiter) {
        return givenString.split(customDelimiter);
    }

    private static int getTotal(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수를 포함하지 말아야 합니다.");
            }
            total += parsedNumber;
        }
        return total;
    }

}
