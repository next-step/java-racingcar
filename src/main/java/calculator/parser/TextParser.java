package calculator.parser;

import static calculator.parser.TextSplitter.BASIC_DELIMITER;

import calculator.util.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextParser {

    private static class DelimiterResolverHolder {
        private static final TextParser INSTANCE = new TextParser();
    }

    public static final String NULL_OR_BLANK_NUMBER = "0";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private TextParser() {
    }

    public static TextParser getInstance() {
        return DelimiterResolverHolder.INSTANCE;
    }

    public TextSplitter parse(final String text) {
        if (!StringUtils.hasText(text)) {
            return new TextSplitter(NULL_OR_BLANK_NUMBER);
        }

        final Matcher delimiterMatcher = CUSTOM_PATTERN.matcher(text);
        if (delimiterMatcher.find()) {
            return new TextSplitter(
                    delimiterMatcher.group(2),
                    BASIC_DELIMITER + "|" + delimiterMatcher.group(1)
            );
        }

        return new TextSplitter(text);
    }

}
