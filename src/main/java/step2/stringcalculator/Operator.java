package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLE("*", (operand1, operand2) -> operand1 * operand2),
    DIVIDE("/", (operand1, operand2) -> operand1 / operand2);

    private BinaryOperator<Double> mathExpression;
    private String operator;

    //  생성자
    Operator(String operator, BinaryOperator<Double> mathExpression) {
        this.operator = operator;
        this.mathExpression = mathExpression;
    }

    public double calculate(double operand1, double operand2) {
        return this.mathExpression.apply(operand1, operand2);
    }

    static Operator of(String operator){
        return Arrays.stream(values())
                .filter(v -> operator.equals(v.operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

}
