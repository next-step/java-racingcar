package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    private final String input;

    public InputParser(String input) {
        this.input = input;
    }

    public ParsedInput parse() {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (m.find()) {
            String delimiter = DEFAULT_DELIMITER + "|" + Pattern.quote(m.group(1));
            return new ParsedInput(delimiter, m.group(2));
        }
        return new ParsedInput(DEFAULT_DELIMITER, input);
    }
}
