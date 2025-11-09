package calculator;

import static java.util.Arrays.*;
import static java.util.Objects.isNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public int splitAndSum(String input) {
        if (isNotExist(input)) {
            return 0;
        }

        String[] targetNumbers = splitNumbers(input);
        return sum(targetNumbers);
    }

    private String[] splitNumbers(String input) {
        Matcher matcherResult = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (matcherResult.find()) {
            String delimiter = matcherResult.group(1);
            String numbers = matcherResult.group(2);

            return numbers.split(delimiter);
        }

        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private int sum(String[] targetNumbers) {
        if (hasJustOneNum(targetNumbers)) {
            return toInt(targetNumbers[0]);
        }

        return stream(targetNumbers)
                .mapToInt(this::processOneNumber)
                .sum();
    }

    private int processOneNumber(String targetNumber) {
        if (isNotDigit(targetNumber)) {
            throw new RuntimeException("입력값은 숫자여야 합니다");
        }

        int number = toInt(targetNumber);

        if (isNotPositive(number)) {
            throw new RuntimeException("입력값은 양수여야 합니다");
        }

        return number;
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private boolean hasJustOneNum(String[] targetNumbers) {
        return targetNumbers.length == 1;
    }

    private boolean isNotExist(String input) {
        return isNull(input) || input.isBlank();
    }

    private boolean isNotPositive(int input) {
        return input < 0;
    }

    private boolean isNotDigit(String input) {
        return !Character.isDigit(input.charAt(0));
    }
}

