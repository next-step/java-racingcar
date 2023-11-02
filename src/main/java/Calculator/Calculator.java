package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int cal(String input) {
        if (isBlank(input)) {
            return 0;
        }
        if (containsDelimiter(input)){
            return sum(split(input, "[,:]"));
        }
        Matcher m = compilePattern(input);
        if (m.find()) {
            return sum(split(m.group(2), m.group(1)));
        }

        return parse(input);
    }

    private static Matcher compilePattern(String input) {
        return Pattern.compile("//(.)\n(.*)").matcher(input);
    }

    private static boolean containsDelimiter(String input) {
        return input.contains(",") || input.contains(":");
    }

    private static int sum(String[] values) {
        int sum = 0;
        for (String value : values) {
            sum += parse(value);
        }
        return sum;
    }

    private static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static int parse(String input) {
        return Integer.parseInt(input);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}
