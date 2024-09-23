package calculator;

import calculator.utils.StringUtils;

import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    private static final Pattern PATTERN_FOR_CUSTOM_DELIMITER = Pattern.compile("//(.)\\n(.*)");
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int TARGET_TEXT_INDEX = 2;

    private StringAddCalculator() {}

    public static int splitAndSum(final String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }

        final var texts = split(text);

        return 0;
    }

    private static String[] split(final String text) {
        final var matcher = PATTERN_FOR_CUSTOM_DELIMITER.matcher(text);
        if (matcher.find()) {
            final var delimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            final var target = matcher.group(TARGET_TEXT_INDEX);

            return target.split(delimiter);
        }

        return text.split(DEFAULT_DELIMITER_REGEX);
    }

}
