package stringadder.delimiter;

import stringadder.exception.StringAddIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterNumberParser extends DefaultNumberParser{
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    @Override
    public List<String> split(String text) {
        if (hasDelimiter(text)) {
            return splitFrom(text);
        }
        return List.of();
    }

    @Override
    public boolean hasDelimiter(String text) {
        return CUSTOM_DELIMITER_PATTERN.matcher(text).find();
    }

    private static List<String> splitFrom(String text) {

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(customDelimiter));
        }

        throw StringAddIllegalArgumentException.DELIMITER_NOT_FOUND;
    }
}
