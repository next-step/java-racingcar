package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitStringToken {
    private static String DEFAULT_PATTERN = ",|:";
    private static Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    static String[] customDelimiterSplit(String token) {
        Matcher m = CUSTOM_PATTERN.matcher(token);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return token.split(DEFAULT_PATTERN);
    }

    static boolean isTextNotNullOrEmpty(String textInput) {
        return textInput == null || textInput.isEmpty();
    }
}
