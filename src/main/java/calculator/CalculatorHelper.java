package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum CalculatorHelper {
    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
    DIVISION("/", (operand1, operand2) -> operand1 / operand2);

    private final String formula;
    private final BinaryOperator<Long> operator;

    CalculatorHelper(String formula, BinaryOperator<Long> operator) {
        this.formula = formula;
        this.operator = operator;
    }

    public static Long calculate(String formula, Long operand1, Long operand2) {
        return getOperator(formula).operator.apply(operand1, operand2);
    }

    private static CalculatorHelper getOperator(String formula) {
        return Arrays.stream(values())
                .filter(calculatorHelper -> calculatorHelper.formula.equals(formula))
                .findFirst()
                .orElseThrow(() ->new IllegalArgumentException("잘못된 연산자입니다."));
    }

}
