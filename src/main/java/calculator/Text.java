package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    public static final String EMPTY_TEXT = "0";
    public static final String DEFAULT_DELIMITER = ",|\\:";
    public static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    private String text;
    private String delimiter = DEFAULT_DELIMITER;

    public Text(String text) {
        this.text = text;
    }

    private static Text emptyText() {
        return new Text(EMPTY_TEXT);
    }

    public static Text input(String input) {
        if (isEmpty(input)) {
            return emptyText();
        }
        Text text = new Text(input);
        if (text.isCustom()) {
            text.changeCustom();
        }
        return text;
    }

    public String[] elements() {
        return text.split(delimiter);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private boolean isCustom() {
        Matcher m = CUSTOM_PATTERN.matcher(text);
        return m.find();
    }

    private void changeCustom() {
        Matcher m = CUSTOM_PATTERN.matcher(text);
        if (m.find()) {
            this.delimiter = m.group(1);
            this.text = m.group(2);
        }
    }
}