package calculator;

import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final Pattern OPERATOR_PATTERN = Pattern.compile("\\w");
    public static final Pattern NUMBER_PATTERN = Pattern.compile("\\d");

    public static int calculate(String text) {
        String[] values = text.split(" ");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);

        for (String value : values) {

        }


        if("+".equals(values[1])) {
            return plus(first, second);
        }

        if("-".equals(values[1])) {
            return minus(first, second);
        }

        if("*".equals(values[1])) {
            return multiply(first, second);
        }

        if("/".equals(values[1])) {
            return divide(first, second);
        }

        throw new IllegalArgumentException("잘못된 연산자!!");
    }

    private static int divide(int first, int second) {
        return first / second;
    }

    private static int multiply(int first, int second) {
        return first * second;
    }

    private static int minus(int first, int second) {
        return first - second;
    }

    private static int plus(int first, int second) {
        return first + second;
    }

}
