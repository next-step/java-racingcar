package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculate {

    private static final Pattern CALCULATE_PATTERN = Pattern.compile("([\\D]?)\\s?(\\d)");

    private StringCalculate() {}

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("input cannot be null or empty");
        }

        Matcher matcher = CALCULATE_PATTERN.matcher(input);

        int result = 0;
        while (matcher.find()) {
            String operator = matcher.group(1);
            int number = Integer.parseInt(matcher.group(2));

            if (operator.equals("")) {
                result = number;
                continue;
            }

            char op = operator.charAt(0);

            result = Operator.calculate(op, result, number);
        }

        return result;
    }
}
