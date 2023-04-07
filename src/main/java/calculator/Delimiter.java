package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }
}
