package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateInfo {

    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n";

    private final String source;
    private final String delimiters;

    public CalculateInfo(String source) {
        this.source = removeDelimiterDeclaration(source);
        this.delimiters = extractDelimiters(source);
    }

    public String[] numberStrings() {
        return source.split(delimiters);
    }

    private String removeDelimiterDeclaration(String source) {
        return source.replaceAll(CUSTOM_DELIMITER_REGEX, "");
    }

    private String extractDelimiters(String source) {
        String customDelimiter = customDelimiter(source);
        return "[" + DEFAULT_DELIMITERS + customDelimiter + "]";
    }

    private String customDelimiter(String source) {
        Pattern customPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = customPattern.matcher(source);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}
