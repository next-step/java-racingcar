package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Source {

    private static final String DEFAULT_DELIMITER = "[:,]";
    ;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.+)\n(.*)");

    public String[] split(String input) {
        String param = param(input);
        String delimiter = delimiter(input);
        return param.split(delimiter);
    }

    private String param(String input) {
        Matcher matcher = matcher(input);
        if (matcher.find()) {
            return matcher.group(2);

        }
        return input;
    }

    private String delimiter(String input) {
        Matcher matcher = matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    private Matcher matcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }
}