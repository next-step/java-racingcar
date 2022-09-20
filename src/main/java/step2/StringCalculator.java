package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern CUSTOM_SEPARATOR = Pattern.compile(("//(.)\n(.*)"));
    private static final String FIRST_DEFAULT_DELIMITER = ":";
    private static final String SECOND_DEFAULT_DELIMITER = ",";
    private static final String OR = "|";
    private final Numbers numbers;

    public StringCalculator(Numbers numbers) {
        this.numbers = numbers;
    }

    public StringCalculator(String numbers) {
        this(new Numbers(numbers));
    }

    public int calculate() {
        String separator = extractSeparator();
        String expression = extractExpression();
        return Arrays.stream(expression.split(separator))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String getRegex() {
        Matcher separatorMatcher = CUSTOM_SEPARATOR.matcher(numbers.numbers());
        String regex = FIRST_DEFAULT_DELIMITER + OR + SECOND_DEFAULT_DELIMITER;
        if (separatorMatcher.find()) {
            regex = separatorMatcher.group(1);
        }
        return regex;
    }

    private String deleteSeparator() {
        return numbers.numbers().replaceAll("//\\D\\n", "");
    }
}
