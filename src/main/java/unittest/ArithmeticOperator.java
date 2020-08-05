package unittest;

import java.util.function.BiFunction;

public enum ArithmeticOperator {

    ADD_OPERATOR("+", (a, b) -> a + b),
    SUBSTRACT_OPERATOR("-", (a, b) -> a - b),
    MULTIPLY_OPERATOR("*", ( a, b) -> a * b),
    DIVIDE_OPERATOR("/", (a, b) -> a / b);

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;


    ArithmeticOperator(String operater, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operater;
        this.expression = expression;
    }

    public int calculate(int a, int b) {
        return expression.apply(a, b);
    }


}
