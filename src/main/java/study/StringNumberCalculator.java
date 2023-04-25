package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringNumberCalculator {
    public static final String DEFAULT_DELIMITER_REGEX = ",|:";

    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final int DELIMITER_GROUP = 1;
    private static final int OPERAND_GROUP = 2;

    public static String getDelimiterRegex(String sample) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(sample);

        if (matcher.find()) {
            return matcher.group(DELIMITER_GROUP);
        }

        return DEFAULT_DELIMITER_REGEX;
    }

    public static String getTarget(String sample) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(sample);

        if (matcher.find()) {
            return matcher.group(OPERAND_GROUP);
        }

        return sample;
    }

    public static String[] getOperand(String sample) {
        return getTarget(sample).split(getDelimiterRegex(sample));
    }

    public static int sumPatternString(String sample) {
        if (StringUtils.isBlank(sample)) {
            return 0;
        }

        String[] data = getOperand(sample);

        return sum(data);

    }

    private static int sum(String[] data) {
        return Arrays.stream(data).mapToInt(stringNumber -> {
            int integerNumber = convertToInteger(stringNumber);
            validPositiveNumber(integerNumber);

            return integerNumber;
        }).sum();
    }

    private static int convertToInteger(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
    }

    private static void validPositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수");
        }
    }
}
