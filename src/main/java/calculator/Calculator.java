package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Calculator {
    private final String[] defaultSplitters = {",", ";"};
    private final int defaultReturnValue = 0;

    public int calculate(String input) {
        if (isNullOrBlank(input)) {
            return defaultReturnValue;
        }
        List<Integer> numbers = parseNumbers(input);
        return calculateSum(numbers);
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    private List<Integer> parseNumbers(String input) {
        return convertToIntegers(parseStringNumbers(input));
    }

    private List<String> parseStringNumbers(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return Arrays.asList(m.group(2).split(customDelimiter));
        }
        return parseStringNumbersByDefaultSplitters(input);
    }

    private List<String> parseStringNumbersByDefaultSplitters(String input) {
        return Arrays.asList(input.split(String.join("|", defaultSplitters)));
    }

    private List<Integer> convertToIntegers(List<String> stringNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            int number = convertToInteger(stringNumber);
            numbers.add(number);
        }
        return numbers;
    }

    private int convertToInteger(String stringNumber) {
        try {
            int number = Integer.parseInt(stringNumber);
            checkInputNumberIsAllowed(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 포멧이 맞지 않습니다: " + stringNumber);
        }
    }

    private void checkInputNumberIsAllowed(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수 값이 삽입되었습니다.");
        }
    }

    private int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
