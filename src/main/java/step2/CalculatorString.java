package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorString {
    private static final String DELIMITER_EMPTY = " ";
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_COLON = ":";
    private static final String DELIMITER_MIX = DELIMITER_COMMA + "|" + DELIMITER_COLON;
    private static final String PATTERN_STRING = "//(.)\n(.*)";
    private static final Pattern COMPILED_PATTERN =  Pattern.compile(PATTERN_STRING);

    private final String text;
    private final String delimiter;

    private CalculatorString(String text, String delimiter) {
        this.text = text;
        this.delimiter = delimiter;
    }

    public static CalculatorString of(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new CalculatorString(text, DELIMITER_EMPTY);
        }

        Matcher m = COMPILED_PATTERN.matcher(text);

        if (m.find()) {
            return new CalculatorString(m.group(2), m.group(1));
        }

        if (text.contains(DELIMITER_COMMA) && text.contains(DELIMITER_COLON)) {
            return new CalculatorString(text, DELIMITER_MIX);
        }

        if (text.contains(DELIMITER_COMMA)) {
            return new CalculatorString(text, DELIMITER_COMMA);
        }

        if (text.contains(DELIMITER_COLON)) {
            return new CalculatorString(text, DELIMITER_COLON);
        }

        return new CalculatorString(text, DELIMITER_EMPTY);
    }

    public String getText() {
        return this.text;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public boolean empty() {
        if (this.text == null || this.text.trim().isEmpty()) {
            return true;
        }

        return false;
    }

    public boolean numeral() {
        try {
            Integer.parseInt(this.text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
