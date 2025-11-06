package study.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final String SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public static String[] split(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(input);

        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }

        return input.split(SEPARATOR);
    }
}
