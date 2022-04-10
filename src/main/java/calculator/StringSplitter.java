package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final String CUSTOM_DELIMITER_REGEX = "^//(.)\n(.*)$";
    private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
    private static final int INPUT_STRING_GROUP_INDEX = 2;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final String DEFAULT_DELIMITER = ",|:";

    private final String operandsString;
    private final String delimiter;

    public StringSplitter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.find()) {
            this.operandsString = matcher.group(INPUT_STRING_GROUP_INDEX);
            this.delimiter = matcher.group(CUSTOM_DELIMITER_GROUP_INDEX);
            return;
        }

        this.operandsString = input;
        this.delimiter = DEFAULT_DELIMITER;
    }

    public List<String> split() {
        return Arrays.asList(operandsString.split(delimiter));
    }
}
