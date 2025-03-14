package step2.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (!isValid(input)) {
            return 0;
        }
        int[] tokens = tokenize(input);
        return sum(tokens);
    }

    public static boolean isValid(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        if (Pattern.matches("(//\\D\\n)*(\\d+\\D)*\\d+", input)) {
            return true;
        }
        throw new RuntimeException();
    }

    public static int[] tokenize(String input) {
        String[] delimiters = new String[]{",", ":"};
        Matcher m = Pattern.compile("//(\\D)\n(.*)").matcher(input);
        if (m.find()) {
            delimiters = new String[]{delimiters[0], delimiters[1], m.group(1)};
            input = m.group(2);
        }

        String[] tokens = input.split(String.format("[%s]", String.join("", delimiters)));
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
    }

    public static int sum(int[] tokens) {
        return Arrays.stream(tokens).sum();
    }
}

