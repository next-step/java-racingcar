package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String separator = DEFAULT_SEPARATOR;
        String numberText = text;

        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
        if (m.find()) {
            separator = m.group(1);
            numberText = m.group(2);
        }

        String[] numbers = numberText.split(separator);

        return sumNumbers(numbers);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.isEmpty()) {
                int value = Integer.parseInt(number);
                if (value < 0) {
                    throw new RuntimeException("음수는 입력할 수 없습니다: ");
                }
                sum += value;
            }
        }

        return sum;
    }
}
