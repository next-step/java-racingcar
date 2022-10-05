package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        String[] numArr = tokens(text);
        int result = add(numArr);

        return result;
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] tokens(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            return m.group(2).split(DELIMITER + '|' + m.group(1));
        }

        return text.split(DELIMITER);
    }

    private static int add(String[] tokens) {
        int result = 0;

        for (String token : tokens) {
            int num = Integer.parseInt(token);

            if (num < 0) {
                throw new RuntimeException();
            }

            result += num;
        }

        return result;
    }
}
