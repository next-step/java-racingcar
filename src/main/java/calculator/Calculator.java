package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String DELIMITER = "delimiter";
    private static final String NUMBER_STRING = "numberString";
    private static final String CUSTOM_DELIMITER_INPUT_REX = "//(?<" + DELIMITER + ">.)\\n(?<" + NUMBER_STRING + ">.*)";
    private static final String NEGATIVE_VALUE_EXCEPTION_MESSAGE = "Negative values not allowed";
    private static final Pattern CUSTOM_DELIMITER_INPUT_PATTERN = Pattern.compile(CUSTOM_DELIMITER_INPUT_REX);

    private List<Integer> numbers = Collections.emptyList();

    public Calculator(String text) {
        if (isNullOrBlank(text)) {
            return;
        }

        String delimiter = DEFAULT_DELIMITER;
        String numberString = text;

        Matcher CustomDelimiterMatcher = CUSTOM_DELIMITER_INPUT_PATTERN.matcher(text);

        if(CustomDelimiterMatcher.find()) {
            delimiter = extractDelimiter(CustomDelimiterMatcher);
            numberString = extractNumberString(CustomDelimiterMatcher);
        }

        extractNumbersFromNumberString(numberString, delimiter);
    }

    public Integer sum() {
        if (numbers.isEmpty()) {
            return 0;
        }
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private String extractDelimiter(Matcher matcher) {
        return matcher.group(DELIMITER);
    }

    private String extractNumberString(Matcher matcher) {
        return matcher.group(NUMBER_STRING);
    }

    private void extractNumbersFromNumberString(String numberString, String delimiter) {
        this.numbers = parseInt(split(numberString, delimiter));
    }

    private static List<String> split(String text, String delimiter) {
        return Arrays.stream(text.split(delimiter))
                .collect(Collectors.toList());
    }

    private static List<Integer> parseInt(List<String> strings) {
        return strings.stream()
                .map(Integer::parseInt)
                .peek(rejectNegativeValues())
                .collect(Collectors.toList());
    }

    private static Consumer<Integer> rejectNegativeValues() {
        return integer -> {
            if (integer < 0) throw new RuntimeException(NEGATIVE_VALUE_EXCEPTION_MESSAGE);
        };
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }
}
