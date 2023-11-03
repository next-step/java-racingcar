package step2;

import java.util.Arrays;

public class StringCalculator {

    private static final String[] DEFAULT_DELIMITERS = {",", ":"};
    private static final String[] CUSTOM_DELIMITERS = {"//", "\n"};

    public int calculate(String string) {
        if (hasNotValue(string)) {
            return 0;
        }

        if (isDefaultDelimiter(string)) {
            string = string.replace(DEFAULT_DELIMITERS[0], DEFAULT_DELIMITERS[1]);
        }

        if (isCustomDelimiter(string)) {
            string = convertToDefaultDelimiter(string);
        }

        return validateWith(string.split(DEFAULT_DELIMITERS[1]));
    }

    private boolean hasNotValue(String string) {
        return string == null || string.isBlank() || string.isEmpty();
    }

    private boolean isDefaultDelimiter(String string) {
        return string.contains(DEFAULT_DELIMITERS[0]) || string.contains(DEFAULT_DELIMITERS[1]);
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
        int idx = string.indexOf(CUSTOM_DELIMITERS[0]) + 2;
        return string.substring(idx);
    }

    private int validateWith(String[] splitedString) {
        try {
            return Arrays.stream(splitedString)
                .mapToInt(Integer::parseInt)
                .sum();
        } catch (NumberFormatException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
