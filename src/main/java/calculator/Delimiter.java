package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String basic = ":|,";
    private final String custom;

    private Delimiter(String custom) {
        this.custom = custom;
    }

    public static Delimiter of(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return new Delimiter(m.group(1));
        }

        return new Delimiter("");
    }

    public boolean isCustomDelimiter() {
        return !custom.isEmpty();
    }

    public String delimiterExpression() {
        if (this.isCustomDelimiter()) {
            return basic + "|" + custom;
        }

        return basic;
    }
}
