package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String COMMA = ",|:";
    private static final String CUSTOM_COMMA = "//(.)\n(.*)";

    public static String findDelimiter(String text) {
        Pattern pattern = Pattern.compile(CUSTOM_COMMA);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return COMMA;
    }

    public static String findText(String text) {
        Pattern pattern = Pattern.compile(CUSTOM_COMMA);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(2);
        }
        return text;
    }
}
