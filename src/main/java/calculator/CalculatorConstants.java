package calculator;

import java.util.regex.Pattern;

public class CalculatorConstants {
    public static final String DEFAULT_DELIMITER_TEXT = ",|:";
    public static final String REGEX_FOR_FIND_CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final Pattern PATTERN_FOR_FIND_CUSTOM_DELIMITER = Pattern.compile(REGEX_FOR_FIND_CUSTOM_DELIMITER);
}
