package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String COMMA_DELIMITER = ",|:";
    private static final String NEGATIVE = "-";
    private static final Pattern REGULAR_CUSTOM = Pattern.compile("//(.)\n(.*)");
    private static final Pattern REGULAR_COMMA_DELIMITER = Pattern.compile(COMMA_DELIMITER);
    public static final int MATCHER_DELIMITER_INDEX = 1;
    public static final int MATCHER_TARGET_INDEX = 2;

    private StringAddCalculator() {}

    public static int splitAndSum(String str) {

        if (str == null || str.isEmpty()) {
            return 0;
        }

        if (str.length() == 1) {
            validateDigit(str);
            return Integer.parseInt(str);
        }

        if (str.contains(NEGATIVE)) {
            throw new RuntimeException("음수는 불가능합니다.");
        }

        if (REGULAR_COMMA_DELIMITER.matcher(str).find()) {
            String[] splitStrings = str.split(COMMA_DELIMITER);
            return addStringArray(splitStrings);
        }

        Matcher matcher = REGULAR_CUSTOM.matcher(str);
        if (matcher.find()) {
            return addStringArray(findByRegular(matcher));
        }

        throw new IllegalArgumentException("값을 잘못 입력하였습니다.");
    }

    private static int addStringArray(final String[] splitStrings) {

        int result = 0;
        for (String splitString : splitStrings) {

            result += Integer.parseInt(splitString);
        }
        return result;
    }

    private static String[] findByRegular(final Matcher matcher) {

        final String customDelimiter = matcher.group(MATCHER_DELIMITER_INDEX);
        return matcher.group(MATCHER_TARGET_INDEX).split(customDelimiter);
    }

    private static void validateDigit(final String str) {

        for (int i = 0; i < str.length(); i++) {
            validateDigit(str.charAt(i));
        }
    }

    private static void validateDigit(char c) {

        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }
}
