package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum CalculatorHelper {
    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
    DIVISION("/", (operand1, operand2) -> {
        CalculatorValidator.validateDenominator(operand2);
        return operand1 / operand2;
    });

    private final String operator;
    private final BinaryOperator<Long> operatorFunction;

    CalculatorHelper(String operator, BinaryOperator<Long> operatorFunction) {
        this.operator = operator;
        this.operatorFunction = operatorFunction;
    }

    public static Long calculate(String formula, Long operand1, Long operand2) {
        return getOperatorFunction(formula).operatorFunction
                .apply(operand1, operand2);
    }

    private static CalculatorHelper getOperatorFunction(String formula) {
        return Arrays.stream(values())
                .filter(calculatorHelper -> calculatorHelper.operator
                        .equals(formula))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자입니다."));
    }

}
