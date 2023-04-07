package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    private List<Integer> numbers = Collections.emptyList();

    private String inputNumberString;

    private String delimiter = DEFAULT_DELIMITER;

    private static final String DEFAULT_DELIMITER = "[,:]";

    private static final String CUSTOM_DELIMITER_INPUT_FORMAT = "//(.)\\n(.*)";

    public Calculator(String text) {
        if (isNotBlank(text)) {
            extractCustomDelimiter(text);
            extractNumbers();
        }
    }

    public Integer sum() {
        if (numbers.isEmpty()) return 0;
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    private void extractCustomDelimiter(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_INPUT_FORMAT).matcher(text);
        if (matcher.find()) {
            this.delimiter = matcher.group(1);
            this.inputNumberString = matcher.group(2);
            return;
        }
        this.inputNumberString = text;
    }

    private void extractNumbers() {
        this.numbers = parseInt(split(inputNumberString, delimiter));
    }

    private static List<String> split(String text, String delimiter) {
        return Arrays.stream(text.split(delimiter)).collect(Collectors.toList());
    }

    private static List<Integer> parseInt(List<String> strings) {
        return strings.stream()
                .map(Integer::parseInt)
                .peek(integer -> {
                    if (integer < 0) throw new RuntimeException("Negative values not allowed");
                })
                .collect(Collectors.toList());
    }

    private static boolean isNotBlank(String text) {
        return text != null && !text.isBlank();
    }
}
