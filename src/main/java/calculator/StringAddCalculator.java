package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int TEXT_INDEX = 2;
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        return sum(split(text));
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (m.find()) {
            return m.group(TEXT_INDEX).split(m.group(CUSTOM_DELIMITER_INDEX));
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static int sum(String[] split) {
        int sum = 0;

        for (String s : split) {
            sum += parseInt(s);
        }

        return sum;
    }

    private static int parseInt(String s) {

        if(isNotNumberOrNegative(s)) {
            throw new RuntimeException("숫자 이외의 값 또는 음수가 입력됨 : " + s);
        }

        return Integer.parseInt(s);
    }

    private static boolean isNotNumberOrNegative(String s) {
        return !s.matches("^[0-9]+$");
    }

}