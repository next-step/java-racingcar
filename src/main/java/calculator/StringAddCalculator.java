package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String COMMA_DELIMITER = ",|:";
    private static final String NEGATIVE = "-";
    private static final Pattern REGULAR_CUSTOM = Pattern.compile("//(.)\n(.*)");
    private static final Pattern REGULAR_COMMA_DELIMITER = Pattern.compile(COMMA_DELIMITER);
    public static final int SIZE_ONE_NUMBER = 1;

    public static int splitAndSum(String str) {

        if (Objects.isNull(str) || str.isEmpty()) {
            return 0;
        }

        if (str.length() == SIZE_ONE_NUMBER) {
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

    private static String[] findByRegular(final Matcher matcher) {

        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }

    private static int addStringArray(final String[] splitStrings) {

        int result = 0;
        for (String splitString : splitStrings) {

            result += Integer.parseInt(splitString);
        }
        return result;
    }
}
