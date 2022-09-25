package nextstep.javaracingcar.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculatorInput {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITERS = "[,:]";

    private final String delimiter;
    private final String values;

    StringCalculatorInput(final String input) {

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null 이거나 공백일 수 없습니다.");
        }

        final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        final boolean hasCustomDelimiter = matcher.find();

        if (hasCustomDelimiter) {
            this.delimiter = matcher.group(1);
            this.values = matcher.group(2);
            return;
        }

        this.delimiter = DEFAULT_DELIMITERS;
        this.values = input;
    }

    PositiveNumber[] values() {
        final String[] values = this.values.split(delimiter);
        PositiveNumber[] numbers = new PositiveNumber[values.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = PositiveNumber.from(values[i]);
        }
        return numbers;
    }
}
