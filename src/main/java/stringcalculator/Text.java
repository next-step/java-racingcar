package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {

    private static final String BASIC_DELIMITER = ":|,";
    private static final String CUSTOM_REGEX = "^//(.)\n(.*)";
    private final String text;

    public Text(String text) {
        this.text = text;
    }

    public String[] parse() {
        if (text == null || text.isBlank()) {
            return new String[]{};
        }

        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }

        return text.split(BASIC_DELIMITER);
    }
}
