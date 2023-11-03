package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern SEPARATE_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static int cal(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(split(text));
    }

    private static String[] split(String text) {
        Matcher matcher = SEPARATE_PATTERN.matcher(text);
        if (matcher.find()) {
            text = matcher.group(2);
            return text.split(matcher.group(1));
        }
        return text.split(",|:");
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
