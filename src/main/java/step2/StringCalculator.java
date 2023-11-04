package step2;

import java.util.Arrays;

public class StringCalculator {

    private static final String[] DEFAULT_DELIMITERS = {",", ":"};
    private static final String[] CUSTOM_DELIMITERS = {"//", "\\n"};

    public int calculate(String string) {
        if (isNone(string)) {
            return 0;
        }

        String stringConverted = convertToSameDelimiter(string);
        int[] numbers = validate(stringConverted.split(DEFAULT_DELIMITERS[1]));

        return sum(numbers);
    }

    private boolean isNone(String string) {
        return string == null || string.isBlank() || string.isEmpty();
    }

    private String convertToSameDelimiter(String string) {
        if (hasNotDelimiter(string)) {
            return string;
        }

        if (isCustomDelimiter(string)) {
            return convertToDefaultDelimiter(string);
        }

        return string.replace(DEFAULT_DELIMITERS[0], DEFAULT_DELIMITERS[1]);
    }

    private boolean hasNotDelimiter(String string) {
        return !(string.contains(DEFAULT_DELIMITERS[0]) || string.contains(DEFAULT_DELIMITERS[1]) ||
            string.contains(CUSTOM_DELIMITERS[0]) || string.contains(CUSTOM_DELIMITERS[1]));
    }

    private boolean isCustomDelimiter(String string) {
        return string.contains(CUSTOM_DELIMITERS[0]) || string.contains(CUSTOM_DELIMITERS[1]);
    }

    private String convertToDefaultDelimiter(String string) {
        String[] splitedString = string.split(CUSTOM_DELIMITERS[1]);
        String delimeter = findDelimeter(splitedString[0]);

        return splitedString[1].replace(delimeter, DEFAULT_DELIMITERS[1]);
    }

    private String findDelimeter(String string) {
        int delimiterIdx = string.indexOf(CUSTOM_DELIMITERS[0]) + 2;
        return string.substring(delimiterIdx);
    }

    private int[] validate(String[] splitedString) {
        int[] numbers = validateChar(splitedString);

        if (isNegative(numbers)) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        return numbers;
    }

    private int[] validateChar(String[] splitedString) {
        int[] numbers;

        try {
            numbers = Arrays.stream(splitedString)
                .mapToInt(Integer::parseInt)
                .toArray();
        } catch (NumberFormatException e) {
            throw new RuntimeException(e.getMessage());
        }

        return numbers;
    }

    private boolean isNegative(int[] numbers) {
        return Arrays.stream(numbers)
            .anyMatch(number -> number < 0);
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers)
            .sum();
    }
}
