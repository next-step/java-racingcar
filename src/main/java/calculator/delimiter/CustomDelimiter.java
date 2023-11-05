package calculator.delimiter;

import calculator.Splitter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter{

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private String delimiter;
    private String content;

    private Matcher matcher;

    @Override
    public List<String> parse(String text) {

        if (match(text)) {
            return splitMatch(text);
        }

        return Arrays.asList(text);
    }

    private List<String> splitMatch(String text) {
        matcher = matcher(text);
        matcher.matches();
        delimiter = matcher.group(1);
        content = matcher.group(2);
        return Splitter.split(content, delimiter);
    }

    public static boolean match(String text) {
        return matcher(text).matches();
    }

    private static Matcher matcher(String text) {
        return CUSTOM_DELIMITER_PATTERN.matcher(text);
    }
}
