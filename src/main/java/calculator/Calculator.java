package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String SPLITTERS = ",:";

    public int calculate(String input) throws RuntimeException {
        if (isBlankOrNull(input))
            return 0;

        return getSum(input);
    }

    private int getSum(String input) {
        return Arrays.stream(split(input))
                .mapToInt(this::stringToInt)
                .peek(this::checkNegative)
                .sum();
    }


    private boolean isBlankOrNull(String input) {
        return input == null || input.isEmpty();
    }

    private String[] split(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            return matcher.group(2).split("[" + SPLITTERS + matcher.group(1) + "]");
        }

        return input.split("[" + SPLITTERS + "]");
    }

    private int stringToInt(String text) throws RuntimeException {
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private void checkNegative(int n) {
        if (n < 0) throw new RuntimeException();
    }
}
