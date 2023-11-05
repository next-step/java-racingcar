package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {
    private static final Pattern customElement = Pattern.compile("//(.)\n(.*)");

    public static int cal(String input) {

        if (isBlank(input)) {
            return 0;
        }

        if (containsCommaColon(input)) {
            return sum(splitString(input, "[,:]"));
        }

        Matcher m = compilePattern(input);
        if (m.find()) {
            return sum(splitString(m.group(2), m.group(1)));
        }

        return Integer.parseInt(input);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static boolean containsCommaColon(String input) {
        return input.contains(",") || input.contains(":");
    }

    private static String[] splitString(String input, String element) {
        return input.split(element);
    }

    private static int sum(String[] inputs) {
        int result = 0;
        for (String input: inputs) {
            validateNagative(input);
            result += Integer.parseInt(input);
        }
        return result;
    }
    private static Matcher compilePattern(String input) {
        return customElement.matcher(input);
    }

    private static void validateNagative(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new NumberFormatException("For input string: " + input);
        }
    }
}
