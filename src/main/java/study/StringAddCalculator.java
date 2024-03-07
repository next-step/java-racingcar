package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    static int calculate(String text) {
        if (isEmptyString(text)) {
            return 0;
        }

        return sum(splitDelimiter(text));
    }

    private static boolean isEmptyString(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(String[] values) {
        int result = 0;

        for (String value : values) {
            result += validateNumber(value);
        }
        return result;
    }

    private static int validateNumber(String value) {
        if (Integer.parseInt(value) < 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다");
        }
        return Integer.parseInt(value);
    }

    private static String[] splitDelimiter(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return text.split(DEFAULT_DELIMITER);
    }
}
