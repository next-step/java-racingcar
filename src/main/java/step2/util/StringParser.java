package step2.util;

import java.util.regex.Pattern;

public class StringParser {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String NEGATIVE_REGEX = "(-\\d+).*";

    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    public static final Pattern NEGATIVE_PATTERN = Pattern.compile(NEGATIVE_REGEX);

}
