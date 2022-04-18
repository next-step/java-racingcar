package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitterFactory {
    private static final String CUSTOM_DELIMITER_REGEX = "^//(.)\n(.*)$";
    private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
    private static final int INPUT_STRING_GROUP_INDEX = 2;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    private static final String DEFAULT_DELIMITER = ",|:";

    public static StringSplitter resolve(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (hasCustomDelimiter(matcher)) {
            return new StringSplitter(matcher.group(INPUT_STRING_GROUP_INDEX), matcher.group(CUSTOM_DELIMITER_GROUP_INDEX));
        }

        return new StringSplitter(input, DEFAULT_DELIMITER);
    }

    private static boolean hasCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }
}
