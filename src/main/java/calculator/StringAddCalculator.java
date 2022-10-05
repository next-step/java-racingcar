package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");

    private String input;
    private String delimiter = DEFAULT_DELIMITER;

    public StringAddCalculator(String input) {
        this.input = input;
    }

    public int calculate() {
        if (isBlank(input)) {
            return 0;
        }

        setCustomDelimiter();

        return sum(toInts(split(input)));
    }

    private boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private void setCustomDelimiter() {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.matches()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }
    }

    private String[] split(String input) {
        return input.split(delimiter);
    }

    private Positive[] toInts(String[] values) {
        return Arrays.stream(values)
                .map(Positive::new)
                .toArray(Positive[]::new);
    }

    private int sum(Positive[] numbers) {
        return Arrays.stream(numbers)
                .reduce(Positive::plus)
                .orElse(new Positive(0))
                .get();
    }
}
