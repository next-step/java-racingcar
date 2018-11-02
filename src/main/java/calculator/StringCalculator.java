package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public static final Pattern SPLIT_PATTERN = Pattern.compile("\\s");
    public static final Pattern OPERATOR_PATTERN = Pattern.compile("\\W+");

    public static int calculate(String text) {
        String[] values = SPLIT_PATTERN.split(text);

        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length - 1; i++) {
            result = calculate(values, result, i, i + 1);
        }

        return result;
    }

    private static boolean isNotOperator(String value) {
        return !OPERATOR_PATTERN.matcher(value).matches();
    }

    private static int calculate(String[] values, int result, int currentIndex, int nextIndex) {
        if(isNotOperator(values[currentIndex])) {
            return result;
        }
        return calculate(values[currentIndex], result, Integer.parseInt(values[nextIndex]));
    }

    private static int calculate(String operator, int first, int second) {
        switch (operator) {
            case "+" :
                return plus(first, second);
            case "-" :
                return minus(first, second);
            case "*" :
                return multiply(first, second);
            case "/" :
                return divide(first, second);
            default:
                throw new IllegalArgumentException("지원되지 않는 연산자 입니다.");
        }
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
