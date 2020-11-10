package step2;

import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MUL("*", (num1, num2) -> num1 * num2),
    DIV("/", (num1, num2) -> num1 / num2);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator (String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public String getOperator () {
        return operator;
    }

    public int caculate(int num1, int num2){
        return expression.apply(num1, num2);
    }
}