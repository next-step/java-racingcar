import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculatorInput {
    public static final List<String> DEFAULT_DELIMITERS = Arrays.asList(",", ":");
    public static final String CUSTOM_DELIMITER_START_PATTERN = "//";
    public static final String CUSTOM_DELIMITER_END_PATTERN = "\\n";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(String.format("%s(.+)%s(.*)", CUSTOM_DELIMITER_START_PATTERN, CUSTOM_DELIMITER_END_PATTERN));
    private final List<Long> numbers;

    public StringCalculatorInput(String input) {
        var delimiters = getAllDelimitersFromCustomDelimiters(getCustomDelimiters(input));
        var tokenSplitWithDelimiters = split(getToken(input), delimitersToRegex(delimiters));
        numbers = parseStringsToLongs(tokenSplitWithDelimiters);
    }

    private static List<String> split(String input, String regex) {
        return List.of(input.split(regex));
    }

    private static List<String> getAllDelimitersFromCustomDelimiters(List<String> customDelimiters) {
        var delimiters = new ArrayList<String>();
        delimiters.addAll(DEFAULT_DELIMITERS);
        delimiters.addAll(customDelimiters);
        return delimiters;
    }

    private static String delimitersToRegex(List<String> delimiters) {
        var regex = new StringBuilder();
        for (var delimiter : delimiters) {
            regex.append(delimiter).append('|');
        }
        deleteLastChar(regex);
        return regex.toString();
    }

    private static List<Long> parseStringsToLongs(List<String> strings) {
        var longs = new ArrayList<Long>();
        for (var element : strings) {
            longs.add(Long.parseLong(element));
        }
        return longs;
    }

    private static void deleteLastChar(StringBuilder stringBuilder) {
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    public List<Long> getNumbers() {
        return numbers;
    }

    public List<String> getCustomDelimiters(String input) {
        var regexCustomDelimiterPart = 1;
        var matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return List.of(matcher.group(regexCustomDelimiterPart));
        }
        return new ArrayList<>();
    }

    public String getToken(String input) {
        var regexTokenPart = 2;
        var matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(regexTokenPart);
        }
        return input;
    }
}
