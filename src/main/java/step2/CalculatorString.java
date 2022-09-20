package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorString {
    private String text;
    private String delimiter;

    public CalculatorString(String text) {
        this.text = text;
        this.delimiter = extractDelimiter();
    }

    public String text() {
        return this.text;
    }

    public String delimiter() {
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

    private String extractDelimiter() {
        if (this.empty()) {
            return null;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(this.text);

        if (m.find()) {
            this.text = m.group(2);
            return m.group(1);
        }

        if (this.text.indexOf(',') != -1 && this.text.indexOf(':') != -1) {
            return ",|:";
        }

        if (this.text.indexOf(',') != -1) {
            return ",";
        }

        if (this.text.indexOf(':') != -1) {
            return ":";
        }

        return null;
    }
}
