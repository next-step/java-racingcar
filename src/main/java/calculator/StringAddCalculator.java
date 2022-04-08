package calculator;

import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        String DEFAULT_DELIMETER = ",|:";
        Pattern pattern = Pattern.compile(DEFAULT_DELIMETER);
        int result = 0;

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] strings = pattern.split(input);


        for (String string: strings) {
            if (isNumeric(string)) {
                result += Integer.parseInt(string);
            }
        }
        return result;
    }

    public static boolean isNumeric(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
