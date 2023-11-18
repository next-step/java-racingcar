package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private static final String COMMA = ",";
    private static final String COLUMN = ":";
    public static final String DEFAULT_REGEX = COMMA + "|" + COLUMN;
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";

    public static List<String> separate(String text) {
        if (containsDefaultRegex(text)) {
            return createDefaultSeparatedText(text);
        }

        Matcher matcher = getMatcher(text);
        if (matchable(matcher)) {
            return createSeparatedTextWithCustomRegex(matcher);
        }

        return createSimpleText(text);
    }

    private static boolean containsDefaultRegex(String text) {
        return text.contains(COMMA) || text.contains(COLUMN);
    }

    private static List<String> createDefaultSeparatedText(String text) {
        return List.of(text.split(DEFAULT_REGEX));
    }

    private static Matcher getMatcher(String text) {
        return Pattern.compile(CUSTOM_REGEX).matcher(text);
    }

    private static boolean matchable(Matcher matcher) {
        return matcher.find();
    }

    private static List<String> createSeparatedTextWithCustomRegex(Matcher matcher) {
        return List.of(createTarget(matcher).split(createDelimiter(matcher)));
    }

    private static String createTarget(Matcher matcher) {
        return matcher.group(2);
    }

    private static String createDelimiter(Matcher matcher) {
        return matcher.group(1);
    }

    private static List<String> createSimpleText(String text) {
        return List.of(text);
    }
}
