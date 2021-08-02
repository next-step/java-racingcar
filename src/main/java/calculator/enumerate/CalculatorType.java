package calculator.enumerate;

import java.util.function.BiFunction;

public enum CalculatorType {
    ADDITION('+', Integer::sum),
    SUBTRACTION('-', (first, second) -> first - second),
    MULTIPLICATION('*', (first, second) -> first * second),
    DIVISION('/', (first, second) -> {
        if (second == 0) throw new IllegalArgumentException();
        return first / second;
    });

    private char symbol;
    private BiFunction<Integer, Integer, Integer> operation;

    CalculatorType(char symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public char getSymbol() {
        return symbol;
    }

    public int operate(int first, int second) {
        return operation.apply(first, second);
    }
}
