package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public int splitAndSum(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        try {
            String[] numbers = splitNumbers(value);
            validatePositiveIntegers(numbers);

            if (numbers.length == 1) {
                return Integer.parseInt(numbers[0]);
            }

            return sumOfPositiveNumbers(numbers);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("형식에 맞지 않는 입력 값입니다.", e);
        }

    }

    private String[] splitNumbers(String value) {
        Matcher m = CUSTOM_PATTERN.matcher(value);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return value.split("[,:]");
    }

    private void validatePositiveIntegers(String[] numbers) throws IllegalArgumentException {
        for (String numberStr : numbers) {
            int number;
            try {
                number = Integer.parseInt(numberStr);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
            if (number < 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    private int sumOfPositiveNumbers(String[] numbers) {
        int sum = 0;
        for (String numberStr : numbers) {
            int number = Integer.parseInt(numberStr);
            sum += number;
        }
        return sum;
    }
}
