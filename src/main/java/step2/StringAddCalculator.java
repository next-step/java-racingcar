package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_PATTERN_COMPILE = Pattern.compile("//(.)\n(.*)");

    private StringAddCalculator() {}

    public static int splitAndSum(String text) {
        if (isEmptyOrNull(text)) {
            return 0;
        }

        String[] tokens = parseText(text);

        return sum(tokens);
    }

    private static String[] parseText(String text) {
        String delimiters = DEFAULT_DELIMITERS;
        Matcher m = CUSTOM_PATTERN_COMPILE.matcher(text);
        if (m.find()) {
            delimiters = m.group(1);
            text = m.group(2);
        }
        return text.split(delimiters);
    }

    private static int sum(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            result += StringConverter.convertToInteger(token);
        }
        return result;
    }

    private static boolean isEmptyOrNull(String text) {
        return text == null || text.isEmpty();
    }

}
