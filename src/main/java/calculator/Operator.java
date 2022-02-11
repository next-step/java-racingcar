package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
    DIVIDE("/", (operand1, operand2) -> {
        if (operand2 == 0) {
            throw new IllegalArgumentException("0으로 나뉠 수 없습니다");
        }
        return operand1 / operand2;
    });
    private final String symbol;
    private final BiFunction<Double, Double, Double> function;

    Operator(String symbol, BiFunction<Double, Double, Double> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public static Operator matchOperator(String symbol) {
        return Arrays.stream(values()).filter(operator -> operator.symbol.equals(symbol)).findAny()
            .orElseThrow(() -> new IllegalArgumentException("사칙 연산이 아닙니다"));
    }

    public double apply(double operand1, double operand2) {
        return function.apply(operand1, operand2);
    }

}
