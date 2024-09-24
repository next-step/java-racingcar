package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String text) throws RuntimeException {
        if (isEmpty(text)) {
            return 0;
        }

        String[] splitedString = splitFrom(text);
        return sumBy(splitedString);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitFrom(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITERS);
    }

    private static int sumBy(String[] stringArr) throws RuntimeException {
        int sum = 0;
        for (String s : stringArr) {
            int num = getIntFrom(s);
            validateIsNotNegative(num);
            sum += num;
        }
        return sum;
    }

    private static int getIntFrom(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void validateIsNotNegative(int num) throws RuntimeException {
        if (num < 0) {
            throw new RuntimeException("음수는 더할 수 없습니다.");
        }
    }


}
