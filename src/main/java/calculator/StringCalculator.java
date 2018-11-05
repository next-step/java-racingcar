package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final Pattern SPLIT_PATTERN = Pattern.compile("\\s");
    public static final Pattern OPERATOR_PATTERN = Pattern.compile("\\W+");

    private static final Map<String, Operator> operatorMap = new HashMap<>();
    static {
        operatorMap.put("+", (first, second) -> first + second);
        operatorMap.put("-", (first, second) -> first - second);
        operatorMap.put("*", (first, second) -> first * second);
        operatorMap.put("/", (first, second) -> first / second);
    }


    public static int calculate(String text) {
        String[] values = SPLIT_PATTERN.split(text);

        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length - 1; i++) {
            result = calculate(result, values[i], values[i + 1]);
        }

        return result;
    }

    private static int calculate(int result, String currentValue, String nextValue) {
        if(isNotOperator(currentValue)) {
            return result;
        }
        return calculate(currentValue, result, Integer.parseInt(nextValue));
    }

    private static boolean isNotOperator(String value) {
        return !OPERATOR_PATTERN.matcher(value).matches();
    }

    private static int calculate(String operator, int first, int second) {
        if(!operatorMap.containsKey(operator)) {
            throw new IllegalArgumentException("지원되지 않는 연산자 입니다.");
        }

        return operatorMap.get(operator).operate(first, second);
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

    private interface Operator {
        int operate(int first, int second);
    }

}
