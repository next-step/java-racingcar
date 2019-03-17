package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    public int add(String input) throws RuntimeException {
        if (isBlank(input)) {
            return 0;
        }

        return sum(convertStringToInteger(split(input)));
    }

    private List<Integer> convertStringToInteger(String[] splittedInput) {
        return Arrays.stream(splittedInput).map(v -> getInteger(v)).collect(Collectors.toList());
    }

    private int sum(List<Integer> convertedInput) {
        return convertedInput.stream()
                .filter(v -> isPositive(v))
                .mapToInt(v -> v).sum();
    }

    private boolean isPositive(int value) throws IllegalArgumentException {
        if (value < 0) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return customSplit(m);
        }

        return baseSplit(text);
    }

    private String[] customSplit(Matcher m) {
        String customDelimiter = m.group(1);
        return m.group(2).split(customDelimiter);
    }


    private String[] baseSplit(String input) {
        return input.split(",|:");
    }

    private int getInteger(String input) {
        return Integer.parseInt(input);
    }

    private boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}
