package calculator;

import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (a, b) -> a + b),
    SUB("-", (a, b) -> a - b),
    MUL("*", (a, b) -> a * b),
    DIV("/", (a, b) -> a / b);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator findByOperator(String symbol) {
        for (Operator operator : Operator.values()) {
            if (operator.getOperator().equals(symbol)) {
                return operator;
            }
        }
        return Operator.ADD;
    }

    private String getOperator() {
        return operator;
    }

    public int operate(int firstOperand, int secondOperand) {
        return expression.apply(firstOperand, secondOperand);
    }
}


