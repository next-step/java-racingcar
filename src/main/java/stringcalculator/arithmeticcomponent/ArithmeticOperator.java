package stringcalculator.arithmeticcomponent;

import java.util.Arrays;
import java.util.function.BinaryOperator;

/**
 * 연산에 필요한 연산자
 */
public enum ArithmeticOperator {
    PLUS("+", Integer::sum),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private final String operator;
    private final BinaryOperator<Integer> function;

    ArithmeticOperator(String operator, BinaryOperator<Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    static ArithmeticOperator findByOperator(String operator) {
        ArithmeticOperator[] arithmeticOperators = ArithmeticOperator.values();
        return Arrays.stream(arithmeticOperators)
                .filter(arithmeticOperator -> arithmeticOperator.hasOperator(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("operator(%s) is invalid.", operator)));
    }

    public static boolean isContained(String operator) {
        return Arrays.stream(ArithmeticOperator.values())
                .anyMatch(arithmeticOperator -> arithmeticOperator.hasOperator(operator));
    }

    BinaryOperator<Integer> function() {
        return function;
    }

    private boolean hasOperator(String operator) {
        return this.operator.equals(operator);
    }
}
