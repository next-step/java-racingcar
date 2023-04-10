import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorInput {
    public static final String CUSTOM_DELIMITER_START_PATTERN = "//";
    public static final String CUSTOM_DELIMITER_END_PATTERN = "\\n";

    private final String rawInput;

    public StringCalculatorInput(String input) {
        rawInput = input;
    }

    public List<String> getCustomDelimiters() {
        var matcher = getCustomDelimiterAndTokenMatcher(rawInput);
        if (matcher.find()) {
            return List.of(matcher.group(1));
        }
        return new ArrayList<>();
    }

    public String getToken() {
        var matcher = getCustomDelimiterAndTokenMatcher(rawInput);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return rawInput;
    }

    private Matcher getCustomDelimiterAndTokenMatcher(String input) {
        var extractorRegex = String.format("%s(.+)%s(.*)", CUSTOM_DELIMITER_START_PATTERN, CUSTOM_DELIMITER_END_PATTERN);
        return Pattern.compile(extractorRegex).matcher(input);
    }
}
