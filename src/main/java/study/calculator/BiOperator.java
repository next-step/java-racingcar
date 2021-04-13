package study.calculator;

import java.util.function.BiFunction;

public enum BiOperator {
    PLUS("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
    MINUS("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLY("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVIDE("/", (leftOperand, rightOperand) -> leftOperand / rightOperand);

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    BiOperator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return operator;
    }

    public Operand calculate(Operand leftOperand, Operand rightOperand) {
        return Operand.of(
                expression.apply(leftOperand.value, rightOperand.value)
        );
    }
}
