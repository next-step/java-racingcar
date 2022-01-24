package calculator.domain;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        Validator.validateIndivisibleNumber(num2);
        return num1 / num2;
    });

    private static final Operator NON_EXISTNT = null;
    private String operator;
    private BiFunction<Double, Double, Double> operate;

    Operator(String operator, BiFunction<Double, Double, Double> operate) {
        this.operator = operator;
        this.operate = operate;
    }

    public static boolean contains(String operator) {
        if (get(operator) == NON_EXISTNT) {
            return false;
        }
        return true;
    }

    public static Operator get(String operator) {
        for (Operator op : Operator.values()) {
            if (op.operator.equals(operator)) {
                return op;
            }
        }
        return null;
    }

    public double operate(double num1, double num2) {
        return this.operate.apply(num1, num2);
    }
}
