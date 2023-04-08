import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitPolicy {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.+)");
    private static final String NORMAL_DELIMITER_REGEX = ",|;";
    private static final String META_CHARACTER_REGEX = "[.,\\\\+*?\\[^\\]$(){}=!<>|:-]";
    private static final String META_CHARACTER_TO_NORMAL_CHARACTER_FORMAT = "\\%s";
    private static final int CUSTOM_DELIMITER = 1;
    private static final int EXPRESSION = 2;
    private final String str;
    private final Matcher customDelimiterMatcher;

    public StringSplitPolicy(String str) {
        this.str = str;
        this.customDelimiterMatcher = str != null
                                      ? CUSTOM_DELIMITER_PATTERN.matcher(str)
                                      : null;
    }

    public String[] splitByPolicy() {
        if (isMatched()) {
            String customDelimiter = getCustomDelimiter();
            String expression = getExpression();

            return expression.split(customDelimiter);
        }

        return str.split(NORMAL_DELIMITER_REGEX);
    }

    private boolean isMatched() {
        return customDelimiterMatcher.find();
    }

    private String getCustomDelimiter() {
        String customDelimiter = customDelimiterMatcher.group(CUSTOM_DELIMITER);
        if (isMetaCharacter(customDelimiter)) {
            return String.format(META_CHARACTER_TO_NORMAL_CHARACTER_FORMAT, customDelimiter);
        }
        return customDelimiter;
    }

    private boolean isMetaCharacter(String customDelimiter) {
        return customDelimiter.matches(META_CHARACTER_REGEX);
    }

    private String getExpression() {
        return customDelimiterMatcher.group(EXPRESSION);
    }
}
