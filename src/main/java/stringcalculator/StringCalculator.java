package stringcalculator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^(/{2}.\\n).*");
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private final Set<String> delimiters = new HashSet<>();
    private final String text;

    public StringCalculator(String text) {
        initializeDelimiters();
        delimiterValidate(text);
        this.text = text;
    }

    private void initializeDelimiters() {
        delimiters.add(COMMA);
        delimiters.add(COLON);
    }

    private void delimiterValidate(String text) {
        if (containsCustomDelimiter(text)) {
            final String customDelimiter = String.valueOf(text.charAt(2));
            delimiters.add(customDelimiter);
        }
        if (containsNotAnyDelimiters(text)) {
            throw new IllegalArgumentException("구분자가 포함되어 있지 않습니다.");
        }
    }

    private boolean containsCustomDelimiter(String text) {
        return CUSTOM_DELIMITER_PATTERN.matcher(text)
                .find();
    }

    private boolean containsNotAnyDelimiters(String text) {
        return delimiters.stream()
                .noneMatch(text::contains);
    }

    public int sum() {
        return 0;
    }
}
