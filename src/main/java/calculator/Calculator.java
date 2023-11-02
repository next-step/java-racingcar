package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final String DEFAULT_DELIMITER = "[,:]";
    private final int LAST_PREFIX_INDEX = 4;
    private final int CUSTOM_DELIMITER_INDEX = 2;

    public int sumAll(String input) {
        if (input.isBlank()) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        if (input.startsWith("//")) {
            delimiter = updateCustomDelimiter(input);
            input = removeCustomDelimiterPrefix(input);
        }

        return getSum(makeStringToIntArray(delimiter, input));
    }

    private String updateCustomDelimiter(String input) {
        return String.valueOf(DEFAULT_DELIMITER.charAt(0)) + String.valueOf(input.charAt(CUSTOM_DELIMITER_INDEX)) + DEFAULT_DELIMITER.substring(1);
    }

    private String removeCustomDelimiterPrefix(String input) {
        return input.substring(LAST_PREFIX_INDEX + 1);
    }


    private List<Integer> makeStringToIntArray(String delimiter, String input) {
        String[] stringNumbers = input.split(delimiter);

        List<Integer> numbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            numbers.add(checkAndTransformToInt(stringNumber));
        }
        return numbers;
    }

    private Integer checkAndTransformToInt(String stringNumber) {
        return checkCondition(stringToInt(stringNumber));
    }

    private Integer stringToInt(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (Exception e) {
            throw new RuntimeException("숫자 이외의 값이 존재합니다.");
        }
    }

    private Integer checkCondition(Integer number) {
        if (number < 0) {
            throw new RuntimeException("음수 값이 존재합니다.");
        }
        return number;
    }

    private int getSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
