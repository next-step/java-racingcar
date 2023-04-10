package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final int ZERO = 0;
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static Integer splitAndSum(String text) {
        if (isEmpty(text)) return ZERO;
        String[] numbers = splitNumbers(text);
        return sum(numbers);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static Integer parseInt(String text) {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }
        return number;
    }

    private static String[] splitNumbers(String text) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static Integer sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += parseInt(number);
        }
        return sum;
    }
}
