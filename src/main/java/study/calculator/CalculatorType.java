package study.calculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

public enum CalculatorType {

    PLUS("+", (left, right) -> left + right),
    MINUS("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> left / right);

    private String operator;
    private IntBinaryOperator intBinaryOperator;

    CalculatorType(String operator, IntBinaryOperator intBinaryOperator) {
        this.operator = operator;
        this.intBinaryOperator = intBinaryOperator;
    }

    public static CalculatorType findCalculatorTypeByOperator(String operator) {
        Optional<CalculatorType> calculatorType = Arrays.stream(CalculatorType.values()).filter(type -> type.operator.equals(operator)).findFirst();

        return calculatorType.orElseThrow(() -> new IllegalArgumentException("연산 기호가 아닙니다"));
    }

    public int calculate(int firstOperand, int secondOperand) {
        return intBinaryOperator.applyAsInt(firstOperand, secondOperand);
    }
}
