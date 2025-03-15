package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    public static final  String DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static String[] split(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(DELIMITER);
    }
}
