import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static final String DEFAULT_DELIMITER = ",:";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_POSTFIX = "\\n";
    public static final int MINIMUM_LENGTH_OF_CUSTOM_DELIMITER = 1;
    public static final int PREFIX_SIZE = CUSTOM_DELIMITER_PREFIX.length();
    public static final int POSTFIX_SIZE = CUSTOM_DELIMITER_POSTFIX.length();

    public List<String> parse(String given) {
        if (given == null || given.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.stream(splitWithCustomDelimiter(given)).collect(Collectors.toList());
    }

    private String[] splitWithCustomDelimiter(String given) {
        String customDelimiter = findCustomDelimiter(given);
        given = removeCustomDelimiterSeperator(given);
        return given.split(getRegexOf(customDelimiter));
    }

    private String removeCustomDelimiterSeperator(String given) {
        if (hasCustomDelimiter(given)) {
            return given.substring(given.indexOf(CUSTOM_DELIMITER_POSTFIX) + POSTFIX_SIZE);
        }
        return given;
    }

    private String findCustomDelimiter(String given) {
        if (hasCustomDelimiter(given)) {
            return given.substring(given.indexOf(CUSTOM_DELIMITER_PREFIX) + PREFIX_SIZE, given.indexOf(CUSTOM_DELIMITER_POSTFIX));
        }
        return "";
    }

    private boolean hasCustomDelimiter(String given) {
        int prefixPosition = given.indexOf(CUSTOM_DELIMITER_PREFIX);
        int postfixPosition = given.indexOf(CUSTOM_DELIMITER_POSTFIX);
        return prefixPosition == 0 && prefixPosition < postfixPosition + MINIMUM_LENGTH_OF_CUSTOM_DELIMITER;
    }

    private String getRegexOf(String customDelimiter) {
        return "[" + DEFAULT_DELIMITER + customDelimiter + "]";
    }
}
