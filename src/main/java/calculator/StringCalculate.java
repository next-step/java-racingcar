package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculate {

    public static int calculate(String input) {
        Pattern operatorPattern = Pattern.compile("([\\D]?)\\s?(\\d)");

        Matcher matcher = operatorPattern.matcher(input);

        int result = 0;
        while (matcher.find()) {
            String operator = matcher.group(1);
            int number = Integer.parseInt(matcher.group(2));

            if (operator.equals("")) {
                result = number;
                continue;
            }

            char op = operator.charAt(0);
            if (op == '+') {
                result = Operator.PLUS.apply(result, number);
            } else if (op == '-') {
                result = Operator.MINUS.apply(result, number);
            } else if (op == '*') {
                result = Operator.MULTIPLY.apply(result, number);
            } else if (op == '/') {
                result = Operator.DIVIDE.apply(result, number);
            }
        }

        return result;
    }
}
