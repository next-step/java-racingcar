package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_SEPARATOR = ",|:";

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int result = 0;
        final String[] tokens = separate(input);

        for (String s : tokens) {
            NonNegativeNumber number = new NonNegativeNumber(s);
            result += number.getValue();
        }
        return result;
    }

    private static String[] separate(String input) {
        String target = input;

        String separator = DEFAULT_SEPARATOR;
        Matcher m = CUSTOM_SEPARATOR_PATTERN.matcher(target);
        if (m.matches()) {
            separator = separator + "|" + Pattern.quote(m.group(1));
            target = m.group(2);
        }

        return target.split(separator);
    }
}
