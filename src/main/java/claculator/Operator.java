package claculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MUL("*", (num1, num2) -> num1 * num2),
    DIV("/", (num1, num2) -> num1 / num2);

    private final String op;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator (String op, BiFunction<Integer, Integer, Integer> expression) {
        this.op = op;
        this.expression = expression;
    }

    public Operator getOperator (String input) {
        return Arrays.stream(values())
                .filter(op -> op.getOperator().equals(input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private String getOperator () {
        return op;
    }

    public int caculate(int num1, int num2){
        return expression.apply(num1, num2);
    }
}