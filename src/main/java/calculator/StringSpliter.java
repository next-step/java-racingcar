package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSpliter {

    private static final String DEFAULT_DELIMITER = "[:,]";;
    private static final String CUSTOM_DELIMITER = "//(.+)\n(.*)";

    public String[] split(String input) {
        String param=param(input);
        String delimiter=delimiter(input);
        return param.split(delimiter);
    }

    private String param(String input){
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            return matcher.group(2);

        }
        return input;
    }

    private String delimiter(String input){
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            return matcher.group(1);

        }
        return DEFAULT_DELIMITER;
    }
}