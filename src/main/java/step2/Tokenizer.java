package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private static final String BASE_DELIMITER = ",|:";
    private static final String DELIMITER_PATTERN = "//(.)\n(.*)";

    public static String[] tokenize(String source) {
        Matcher customMatcher = getCustomMatcher(source, DELIMITER_PATTERN);
        if (customMatcher.find()) {
            return splitCustom(customMatcher);
        }

        return source.split(BASE_DELIMITER);
    }

    private static Matcher getCustomMatcher(String source, String regex) {
        return Pattern.compile(regex).matcher(source);
    }

    private static String[] splitCustom(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }
}
