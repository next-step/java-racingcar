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
    private static final String CUSTOM_DELIMITER_INPUT_FORMAT = "//(?<delimiter>.)\\n(?<numberString>.*)";

    private String delimiter = DEFAULT_DELIMITER;
    private String numberString;
    private List<Integer> numbers = Collections.emptyList();

    public Calculator(String text) {
        if (isNotBlank(text)) {
            extractCustomDelimiterAndNumberString(text);
            extractNumbersFromNumberString();
        }
    }

    public Integer sum() {
        if (numbers.isEmpty()) {
            return 0;
        }
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void extractCustomDelimiterAndNumberString(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_INPUT_FORMAT).matcher(text);
        if (matcher.find()) {
            this.delimiter = matcher.group("delimiter");
            this.numberString = matcher.group("numberString");
            return;
        }
        this.numberString = text;
    }

    private void extractNumbersFromNumberString() {
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
            if (integer < 0) throw new RuntimeException("Negative values not allowed");
        };
    }

    private static boolean isNotBlank(String text) {
        return text != null && !text.isBlank();
    }
}
