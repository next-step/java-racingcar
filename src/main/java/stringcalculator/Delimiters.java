package stringcalculator;

import java.util.*;
import java.util.stream.Collectors;

public class Delimiters {
    private static final Map<String, String> REGEX_ESCAPE = new HashMap<>();

    static {
        REGEX_ESCAPE.put("+", "\\+");
        REGEX_ESCAPE.put("{", "\\{");
        REGEX_ESCAPE.put("(", "\\(");
        REGEX_ESCAPE.put(")", "\\)");
        REGEX_ESCAPE.put("[", "\\[");
    }
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String BLANK_STRING = " ";
    private static final String DOUBLE_SLASH = "//";
    private static final String CUSTOM_END_STRING = "\\n";
    private static final String ESCAPE_CUSTOM_END_STRING = "\\\\n";
    private final Set<String> delimiters = new HashSet<>();

    public static Delimiters of(String text) {
        return new Delimiters(text);
    }

    public List<String> split(String text) {
        String result = text;
        if (text.contains(CUSTOM_END_STRING)) {
            result = text.split(ESCAPE_CUSTOM_END_STRING)[1];
        }

        for (String delimiter : delimiters) {
            delimiter = REGEX_ESCAPE.getOrDefault(delimiter, delimiter);
            result = result.replaceAll(delimiter, BLANK_STRING);
        }

        return Arrays.stream(result.split(BLANK_STRING)).collect(Collectors.toList());
    }

    private Delimiters(String text) {
        initializeDelimiters();
        validateDelimiter(text);
    }

    private void validateDelimiter(String text) {
        if (containsCustomDelimiter(text)) {
            final String customDelimiter = String.valueOf(text.charAt(2));
            delimiters.add(customDelimiter);
        }
        if (containsNotAnyDelimiters(text)) {
            throw new IllegalArgumentException("구분자가 포함되어 있지 않습니다.");
        }
    }

    private boolean containsCustomDelimiter(String text) {
        return text.contains(CUSTOM_END_STRING) && text.startsWith(DOUBLE_SLASH);
    }

    private boolean containsNotAnyDelimiters(String text) {
        return delimiters.stream()
                .noneMatch(text::contains);
    }

    private void initializeDelimiters() {
        delimiters.add(COMMA);
        delimiters.add(COLON);
    }
}
