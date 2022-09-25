package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String REGEX = "[,:]";
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toPositives(split(text))).getNumber();
    }

    private static String[] split(String text) {
        Matcher m = PATTERN.matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return text.split(REGEX);
    }

    private static Positive sum(Positive[] numbers) {
        Positive result = new Positive(0);
        for (Positive number : numbers) {
            result = result.plus(number);
        }
        return result;
    }

    private static Positive[] toPositives(String[] values) {
        Positive[] result = new Positive[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = toPositive(values[i]);
        }
        return result;
    }

    private static Positive toPositive(String str) {
        return new Positive(str);
    }

    private static boolean isBlank(String text) {
        return text == null || text.equals("");
    }
}
