package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final int ZERO = 0;
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final int CUSTOM_DELIMITER_INDEX = 1;
    public static final int CUSTOM_DELIMITER_TEXT_INDEX = 2;

    public static int splitAndSum(String text) {
        if (isBlankOrNull(text)) {
            return ZERO;
        }

        String[] splitNumbers = split(text);
        PositiveGroup positiveGroup = PositiveGroup.create(splitNumbers);

        return positiveGroup.getSum();
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_INDEX);
            return m.group(CUSTOM_DELIMITER_TEXT_INDEX).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static boolean isBlankOrNull(String text) {
        return text == null || text.isBlank();
    }
}
