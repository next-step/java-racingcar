package calculator;

import java.util.function.BiFunction;

public enum  Operator {
    ADD("+", Integer::sum),
    SUBSTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private String operation;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operation, BiFunction<Integer, Integer, Integer> expression) {
        this.operation = operation;
        this.expression = expression;
    }

    public String getOperation() {
        return operation;
    }

    public int getResult(int num1, int num2) {
        return expression.apply(num1, num2);
    }
}
