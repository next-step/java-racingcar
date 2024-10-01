package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] tokens = getTokens(text);
        return sum(tokens);
    }

    private static String[] getTokens(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private static int sum(String[] operands) {
        int result = 0;
        for (String operandAsString : operands) {
            result += getOperand(operandAsString);
        }
        return result;
    }

    private static int getOperand(String input) {
        int operand = Integer.parseInt(input);
        if (operand < 0) {
            throw new RuntimeException("Negative numbers are not allowed");
        }
        return operand;
    }
}
