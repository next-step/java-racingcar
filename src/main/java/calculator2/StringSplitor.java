package calculator2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitor {

    public static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String SPLIT_CHAR = ",|:";

    public static String[] split(String text) {
        Matcher m = CUSTOM_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(SPLIT_CHAR);
    }
}
