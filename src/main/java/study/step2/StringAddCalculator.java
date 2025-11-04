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

        int sum = 0;
        for (String number : numbers) {
            if (!number.isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }
}
