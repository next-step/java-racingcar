package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");
    private final String input;

    public StringAddCalculator(String input) {
        this.input = input;
    }

    public int calculate() {
        if (isBlank(input)) {
            return 0;
        }

        return sum(toInts(split(input)));
    }

    private boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private String[] split(String input) {
        String delimiter = DEFAULT_DELIMITER;
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.matches()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }

        return input.split(delimiter);
    }

    private Positive[] toInts(String[] values) {
        Positive[] numbers = new Positive[values.length];
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            numbers[i] = new Positive(value);
        }
        return numbers;
    }

    private int sum(Positive[] numbers) {
        int result = 0;
        for (Positive number: numbers) {
            result += number.get();
        }
        return result;
    }
}
