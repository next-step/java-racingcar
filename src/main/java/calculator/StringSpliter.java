package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSpliter {

    private static final String DEFAULT_DELIMITER = "[:,]";;
    public static final String CUSTOM_DELIMITER = "//(.+)\n(.*)";

    public StringSpliter() {
    }

    String[] split(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String group = matcher.group(2);
            return group.split(delimiter);
        }

        return input.split(DEFAULT_DELIMITER);
    }
}