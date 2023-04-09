package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final String DEFAULT_DELIMITER = "[,|:]";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private final String input;

    public StringSplitter(String input) {
        this.input = input;
    }

    public String[] split() {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

}
