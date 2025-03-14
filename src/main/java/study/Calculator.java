package study;

import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_NUMBERS_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    public static int sum(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        return sum(split(s));
    }

    private static String[] split(String s) {
        String delimiterRegex = DEFAULT_NUMBERS_DELIMITER_REGEX;
        if (s.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterEnd = s.indexOf("\n");
            delimiterRegex = Pattern.quote(s.substring(2, delimiterEnd));
            s = s.substring(delimiterEnd + 1);
        }
        return s.split(delimiterRegex);
    }

    private static int sum(String[] numberStrings) {
        int sum = 0;
        for (String numberString : numberStrings) {
            sum += Integer.parseInt(numberString);
        }
        return sum;
    }
}
