package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int TEXT_INDEX = 2;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String NON_NEGATIVE_INTEGER_PATTERN = "^[0-9]+$";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        return sum(parse(text));
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] parse(String text) {

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
        return !s.matches(NON_NEGATIVE_INTEGER_PATTERN);
    }
}