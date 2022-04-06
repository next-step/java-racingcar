package step02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class NumberSplitter {

    private static final Pattern CUSTOM_DELIMITER_EXTRACTION_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    private static final String DEFAULT_DELIMITER = "[,:]";

    public List<Number> extractNumbersWithDelimiter(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }

        Matcher matcher = CUSTOM_DELIMITER_EXTRACTION_PATTERN.matcher(text);
        String[] numbersAsString;

        if (matcher.find()) {
            numbersAsString = splitWitchCustomDelimiter(matcher);
            return transformIntoNumbers(numbersAsString);
        }

        numbersAsString = text.split(DEFAULT_DELIMITER);
        return transformIntoNumbers(numbersAsString);
    }

    private String[] splitWitchCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter + "|" + DEFAULT_DELIMITER);
    }

    private List<Number> transformIntoNumbers(String[] numbersAsString) {
        return Arrays.stream(numbersAsString)
                .map(number -> new Number(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }

}
