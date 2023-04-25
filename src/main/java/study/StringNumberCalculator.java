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

    public static int sum(String sample) {
        if (StringUtils.isBlank(sample)) {
            return 0;
        }

        try {
            String[] data = getOperand(sample);
            return Arrays.stream(data).mapToInt(stringNumber -> {
                int integerNumber = Integer.parseInt(stringNumber);
                if (integerNumber < 0) { // 음수
                    throw new RuntimeException("음수");
                }
                return integerNumber;

            }).sum();
        } catch (NumberFormatException numberFormatException) { //숫자가 아닌 문자
            throw new RuntimeException("음수");
        }
    }
}
