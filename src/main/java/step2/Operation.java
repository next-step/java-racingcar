package step2;

import java.util.function.BiFunction;

public enum Operation {

    PLUS("+",(firstNumber, secondNumber) -> firstNumber + secondNumber),
    MINUS("-",(firstNumber, secondNumber) -> firstNumber - secondNumber),
    MULTIPLY("*",(firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVIDE("/",(firstNumber, secondNumber) -> firstNumber / secondNumber);

    private String symbol;
    private BiFunction<Double, Double, Double> biFunction;

    Operation(String symbol, BiFunction<Double, Double, Double> biFunction) {
        this.symbol = symbol;
        this.biFunction = biFunction;
    }

    public Double calculate(Double firstNumber, Double secondNumber) {
        return biFunction.apply(firstNumber, secondNumber);
    }
}
