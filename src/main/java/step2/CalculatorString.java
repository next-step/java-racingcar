package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorString {
    private static final String DELIMITER_EMPTY = " ";
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_COLON = ":";
    private static final String DELIMITER_MIX = DELIMITER_COMMA + "|" + DELIMITER_COLON;

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

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            return new CalculatorString(m.group(2), m.group(1));
        }

        if (text.indexOf(DELIMITER_COMMA) != -1 && text.indexOf(DELIMITER_COLON) != -1) {
            return new CalculatorString(text, DELIMITER_MIX);
        }

        if (text.indexOf(DELIMITER_COMMA) != -1) {
            return new CalculatorString(text, DELIMITER_COMMA);
        }

        if (text.indexOf(DELIMITER_COLON) != -1) {
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
