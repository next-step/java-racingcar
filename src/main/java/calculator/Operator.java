package calculator;

import java.util.function.BiFunction;

public enum Operator {
    ADDTION("+", (num1, num2) -> (num1 + num2)),
    SUBTRACT("-", (num1, num2) -> (num1 - num2)),
    MULTIPLICATION("*", (num1, num2) -> (num1 * num2)),
    DIVISION("/", (num1, num2) -> (num1 / num2));

    private final String name;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String name, BiFunction<Integer, Integer, Integer> expression) {
        this.name = name;
        this.expression = expression;
    }
//    public Integer calculate(int num1, int num2) {
//        return this.expression.apply(num1, num2);
//    }
//    public Integer calculate(String num1, String num2) {
//        return this.expression.apply(Integer.parseInt(num1), Integer.parseInt(num2));
//    }

    public <T> Integer calculate(T num1, T num2) {
        Integer intNum1 = 0;
        Integer intNum2 = 0;

        if (num1 instanceof String) {
            intNum1 = Integer.parseInt((String) num1);
        }
        if (num1 instanceof Integer) {
            intNum1 = (Integer) num1;
        }
        if (num2 instanceof String) {
            intNum2 = Integer.parseInt((String) num2);
        }
        if (num2 instanceof Integer) {
            intNum2 = (Integer) num2;
        }

        return this.expression.apply(intNum1, intNum2);
    }

    public String getName() {
        return name;
    }
}
