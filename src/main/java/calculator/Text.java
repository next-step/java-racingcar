package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    public static final String DEFAULT_DELIMITER = ",|\\:";
    public static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    private String text;
    private String delimiter;

    private Text(String text, String delimiter) {
        this.text = text;
        this.delimiter = delimiter;
    }

    private static Text emptyText(){
        return new Text("0", "");
    }

    public static Text input(String input) {
        if (isEmpty(input)) {
            return emptyText();
        }
        return new Text(removeDelimiter(input), transferDelimiter(input));
    }

    public String[] getElements() {
        return text.split(delimiter);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String transferDelimiter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (m.find()) {
            return m.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    private static String removeDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(2);
        }
        return text;
    }
}