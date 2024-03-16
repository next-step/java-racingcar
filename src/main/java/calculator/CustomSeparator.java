package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator {

    public static final String DEFAULT_DELIMITER_CHECK_REGEX = ",|:";
    public static final String CUSTOM_DELIMITER_CHECK_REGEX = "//(.)\n(.*)";
    public static final Pattern CUSTOM_DELIMITER_CHECK_PATTERN = Pattern.compile(CUSTOM_DELIMITER_CHECK_REGEX);

    public static String[] separateNumbers(String input) {
        // 구분자 검사
        Matcher m = CUSTOM_DELIMITER_CHECK_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITER_CHECK_REGEX);
    }

}
