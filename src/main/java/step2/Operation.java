package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {

    PLUS(Symbol.PLUS, (firstNumber, secondNumber) -> firstNumber + secondNumber),
    MINUS(Symbol.MINUS, (firstNumber, secondNumber) -> firstNumber - secondNumber),
    MULTIPLY(Symbol.MULTIPLY, (firstNumber, secondNumber) -> firstNumber * secondNumber),
    // TODO : Exception Handling
    DIVIDE(Symbol.DIVIDE, (firstNumber, secondNumber) -> firstNumber / secondNumber );

    private Symbol symbol;
    private BiFunction<Double, Double, Double> calculation;

    Operation(Symbol symbol, BiFunction<Double, Double, Double> calculation) {
        this.symbol = symbol;
        this.calculation = calculation;
    }

    public static Operation getOperation(String symbol) {
        return Arrays.stream(values())
                .filter(operation -> operation.symbol.isEqualTo(symbol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Double calculate(Double firstNumber, Double secondNumber) {
        if(isDivideByZero(secondNumber)) throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        return calculation.apply(firstNumber, secondNumber);
    }

    private boolean isDivideByZero(Double secondNumber) {
        return this.symbol.equals(Symbol.DIVIDE) && secondNumber.equals(0D);
    }
}
