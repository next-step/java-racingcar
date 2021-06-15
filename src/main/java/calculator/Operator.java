package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private String operator;
    private BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    private double calculate(double num1, double num2) {
        return this.expression.apply(num1, num2);
    }

    private static Map<String, Operator> OPERATORS = new HashMap<>();

    static {
        for (Operator value : Operator.values()) {
            OPERATORS.put(value.operator, value);
        }
    }

    public static double calculate(String operator, double num1, double num2) {
        return OPERATORS.get(operator).calculate(num1, num2);
    }

}
