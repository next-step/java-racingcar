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

    private static PositiveNumber sum(PositiveNumber[] numbers) {
        PositiveNumber result = PositiveNumber.of(0);
        for (PositiveNumber number : numbers) {
            result = result.plus(number);
        }
        return result;
    }

    private static PositiveNumber[] toPositives(String[] values) {
        PositiveNumber[] result = new PositiveNumber[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = PositiveNumber.of(values[i]);
        }
        return result;
    }

    private static boolean isBlank(String text) {
        return text == null || text.equals("");
    }
}
