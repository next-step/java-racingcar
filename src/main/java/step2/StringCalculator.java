package step2;

import java.util.Arrays;

public class StringCalculator {

    private static final String[] DEFAULT_DELIMITERS = {",", ":"};
    private static final String[] CUSTOM_DELIMITERS = {"//", "\n"};

    public int calculateWith(String string) {

        boolean isDefault = true;
        if (isCustomDelimiter(string)) {
            String[] splitedString = string.split(CUSTOM_DELIMITERS[1]);
            String delimeter = findDelimeter(splitedString[0]);
            string = splitedString[1].replace(delimeter, DEFAULT_DELIMITERS[1]);
            isDefault = false;
        }

        if (isDefault) {
            string = string.replace(DEFAULT_DELIMITERS[0], DEFAULT_DELIMITERS[1]);
        }

        String[] splitedString = string.split(DEFAULT_DELIMITERS[1]);

        return hasNotNumber(splitedString);
    }

    private boolean isCustomDelimiter(String string) {
        return (string.contains(CUSTOM_DELIMITERS[0]) || string.contains(CUSTOM_DELIMITERS[1]));
    }

    private String findDelimeter(String string) {
        int idx = string.indexOf(CUSTOM_DELIMITERS[0]) + 2;
        return string.substring(idx);
    }

    private int hasNotNumber(String[] splitedString) {
        try {
            return Arrays.stream(splitedString)
                .mapToInt(Integer::parseInt)
                .sum();
        } catch (NumberFormatException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
