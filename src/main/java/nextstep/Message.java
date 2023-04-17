package nextstep;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Message {
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    private static final int DELIMITER_INDEX = 1;
    private static final int TOKENS_INDEX = 2;

    private final List<String> tokens;


    public Message(String text) {
        if (isEmptyText(text)) {
            throw new IllegalArgumentException("Null or empty text is not allowed");
        }
        this.tokens = convertTextToTokens(text);
    }

    private static boolean isEmptyText(String text) {
        return text == null || text.isEmpty();
    }

    public List<String> getTokens() {
        return this.tokens;
    }

    private List<String> convertTextToTokens(String text) {
        final Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (m.find()) {
            String delimiters = m.group(DELIMITER_INDEX);
            return Arrays.asList(m.group(TOKENS_INDEX).split(delimiters));
        }
        return Arrays.asList(text.split(DEFAULT_DELIMITER_REGEX));
    }
}
