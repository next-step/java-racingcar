package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperationSymbol {
    PLUS("+", (firstNumber, secondNumber) -> firstNumber + secondNumber),
    MINUS("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
    MULTIPLY("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVIDE("/", (firstNumber, secondNumber) -> firstNumber / secondNumber);

    private String symbol;
    private BiFunction<Double, Double, Double> expression;

    OperationSymbol(String symbol, BiFunction<Double, Double, Double> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static OperationSymbol getOperationSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(operationSymbol -> operationSymbol.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산기호가 올바르지 않습니다." + symbol));
    }

    public double calculate(double firstNumber, double secondNumber) {
        return expression.apply(firstNumber, secondNumber);
    }
}
