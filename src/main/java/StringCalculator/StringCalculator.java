package StringCalculator;

import java.util.regex.Pattern;

public class StringCalculator {

    private static StringCalculator stringCalculator = new StringCalculator();
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String NUMERIC_REGEXP = "\\d";

    private StringCalculator() {}

    public static StringCalculator getInstance() {
        return stringCalculator;
    }

    public int calculate(String input) {
        if (nullCheck(input)) {
            return 0;
        }
        input = deleteBlank(input);

        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }
        String[] strings = splitString(input);



        return 0;
    }

    public boolean isNumeric(String input) {
        return Pattern.matches(NUMERIC_REGEXP, input);
    }

    public String deleteBlank(String input) {
        return input.replace(" ", "");
    }

    public boolean nullCheck(String input) {
        return input == null || input.isBlank();
    }

    public String[] splitString(String input) {
        return input.split(DEFAULT_SEPARATOR);
    }
}
