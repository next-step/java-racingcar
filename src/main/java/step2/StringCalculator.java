package step2;

import java.util.Arrays;

public class StringCalculator {

    private static final String[] DEFAULT_DELIMITERS = {",", ":"};
    public int calculateWith(String string) {

        String[] splitedString;
        if (string.contains("//") || string.contains("\n")) {
            splitedString = string.split("\n");
            String delimeter = findDelimeter(splitedString[0]);
            splitedString = splitedString[1].split(delimeter);
        } else {
            splitedString = string.replace(DEFAULT_DELIMITERS[0], DEFAULT_DELIMITERS[1])
                .split(DEFAULT_DELIMITERS[1]);
        }

        return Arrays.stream(splitedString)
            .mapToInt(Integer::parseInt)
            .sum();
    }

    private String findDelimeter(String string) {
        return string.substring(2);
    }
}
