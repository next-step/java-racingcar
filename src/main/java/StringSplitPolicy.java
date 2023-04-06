import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitPolicy {

    private static final Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.+)");
    private static final int CUSTOM_DELIMITER = 1;
    private static final int EXPRESSION = 2;
    private final String str;
    private final Matcher customDelimiterMatcher;

    public StringSplitPolicy(String str) {
        this.str = str;
        this.customDelimiterMatcher = str != null
                                      ? customDelimiterPattern.matcher(str)
                                      : null;
    }

    public String[] splitByPolicy() {
        if (isMatched()) {
            String customDelimiter = getCustomDelimiter();
            String expression = getExpression();

            return expression.split(customDelimiter);
        }

        return str.split(",|;");
    }

    private boolean isMatched() {
        return customDelimiterMatcher.find();
    }

    private String getCustomDelimiter() {
        String customDelimiter = customDelimiterMatcher.group(CUSTOM_DELIMITER);
        if (isMetaCharacter(customDelimiter)) {
            return String.format("\\%s", customDelimiter);
        }
        return customDelimiter;
    }

    private boolean isMetaCharacter(String customDelimiter) {
        return customDelimiter.matches("[.,\\\\+*?\\[^\\]$(){}=!<>|:-]");
    }

    private String getExpression() {
        return customDelimiterMatcher.group(EXPRESSION);
    }
}
