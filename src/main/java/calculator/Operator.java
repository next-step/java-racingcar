package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    DIVISION("/", (a, b) -> a / b),
    MULTIPLY("*", (a, b) -> a * b);

    private String operator;
    private BinaryOperator<Integer> calculate;

    Operator(String operator, BinaryOperator<Integer> calculate){
        this.operator = operator;
        this.calculate = calculate;
    }

    public static Operator findOperator(String findOperator){
        return Arrays.stream(values())
                .filter(operator -> operator.equalsTo(findOperator))
                .findFirst().orElse(null);
    }

    private boolean equalsTo(String findOperator) {
        return this.operator.equals(findOperator);
    }

    public int result(int a, int b){
        return calculate.apply(a, b);
    }


}
