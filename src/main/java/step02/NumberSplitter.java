package step02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NumberSplitter {

    private static final Pattern CUSTOM_DELIMITER_EXTRACTION_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    private static final String DEFAULT_DELIMITER = "[,:]";

    public List<String> extractNumbersWithDelimiter(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }

        Matcher matcher = CUSTOM_DELIMITER_EXTRACTION_PATTERN.matcher(text);

        if (matcher.find()) {
            return splitWithCustomDelimiter(matcher);
        }

        return splitWithDefaultDelimiter(text);
    }

    private List<String> splitWithDefaultDelimiter(String text) {
        String[] splitNumbers = text.split(DEFAULT_DELIMITER);
        return Arrays.asList(splitNumbers);
    }

    private List<String> splitWithCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String[] splitNumbers = matcher.group(2).split(customDelimiter + "|" + DEFAULT_DELIMITER);
        return Arrays.asList(splitNumbers);
    }

}
