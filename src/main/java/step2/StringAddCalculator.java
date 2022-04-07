package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static String DEFAULT_REGEX_DELIMITER = ",|:";
    private static String CUSTOM_REGEX_DELIMITER = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        Matcher m = Pattern.compile(CUSTOM_REGEX_DELIMITER).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] splits = m.group(2).split(customDelimiter);
            return sum(toPositives(splits));
        }

        String[] splits = text.split(DEFAULT_REGEX_DELIMITER);
        return sum(toPositives(splits));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static Positive[] toPositives(String[] values) {
        Positive[] arr = new Positive[values.length];
        for (int i = 0; i < values.length; i++) {
            arr[i] = new Positive(values[i]);
        }
        return arr;
    }

    private static int sum(Positive[] positives) {
        int sum = 0;
        for (Positive positive : positives) {;
            sum += positive.value;
        }
        return sum;
    }
}
