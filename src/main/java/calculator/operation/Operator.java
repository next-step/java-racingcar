package calculator.operation;

import calculator.validation.CalculatorValidator;
import calculator.value.CalculatorValue;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
    DIVIDE("/", (operand1, operand2) -> {
        CalculatorValidator.validateDivide(operand1, operand2);
        return operand1 / operand2;
    });

    private final String operator;
    private final BinaryOperator<Long> expression;

    Operator(String operator, BinaryOperator<Long> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Long calculate(CalculatorValue value) {
        return getOperator(value.getOperator())
                .expression
                .apply(value.getOperand1(), value.getOperand2());
    }

    private static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(v -> v.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }
}
