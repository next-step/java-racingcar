import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberParser {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";
    private final String input;

    public NumberParser(String input) {
        this.input = input;
    }

    public String[] parseNumbers() {
        if (isCustomDelimiter()) {
            return parseCustomDelimiterNumbers();
        }
        return parseDefaultDelimiterNumbers();
    }

    private boolean isCustomDelimiter() {
        return input.startsWith("//");
    }

    private String[] parseCustomDelimiterNumbers() {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        matcher.matches();
        String customDelimiter = matcher.group(1);
        String inputNumbers = matcher.group(2);
        return inputNumbers.split(customDelimiter);
    }

    private String[] parseDefaultDelimiterNumbers() {
        return input.split(DEFAULT_DELIMITER);
    }
}
