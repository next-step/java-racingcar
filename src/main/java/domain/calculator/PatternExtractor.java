package domain.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExtractor {
    private String text;
    private String separator;
    private Matcher matcher;

    public PatternExtractor(String value) {
        this.text = value;
        this.separator = ",";
        this.matcher = Pattern.compile("//(.)\n(.*)").matcher(value);
    }

    public String getText() {
        if (!matcher.find(0)) {
            return this.text;
        }

        return matcher.group(2);
    }

    public String getSeparator() {
        if (!matcher.find(0)) {
            return this.separator;
        }

        return matcher.group(1);
    }
}
