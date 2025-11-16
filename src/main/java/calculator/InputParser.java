package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public InputParser() {
    }

    public List<String> split(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (m.find()) {
            return Arrays.stream(m.group(2).split( DEFAULT_DELIMITER + "|" + Pattern.quote(m.group(1))))
                    .toList();
        }
        return Arrays.stream(input.split(DEFAULT_DELIMITER))
                .toList();
    }
}
