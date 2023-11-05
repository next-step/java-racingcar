package study;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String EMPTY_NUMBER = "0";

    private Delimiter delimiter;
    private String content;

    Parser(String text) {

        if(empty(text)) {
            delimiter = new Delimiter();
            content = EMPTY_NUMBER;
            return;
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.matches()) {
            delimiter = new Delimiter(matcher.group(1));
            content = matcher.group(2);
            return;
        }

        delimiter = new Delimiter();
        content = text;
    }

    private boolean empty(String text) {
        return text == null || text.isBlank();
    }

    public Delimiter delimiter() {
        return delimiter;
    }

    public String content() {
        return content;
    }
}