package calculator.enums;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperationSymbol {

    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2),
    ;

    String symbol;
    BiFunction<Integer, Integer, Integer> function;

    OperationSymbol(String symbol, BiFunction<Integer, Integer, Integer> function) {

        this.symbol = symbol;
        this.function = function;
    }

    public String getSymbol() {

        return symbol;
    }

    public static OperationSymbol from(String symbol) {

        return Arrays.stream(OperationSymbol.values())
                .filter(operationSymbol -> operationSymbol.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(UnsupportedOperationException::new);
    }

    public int apply(int num1, int num2) {
        return function.apply(num1, num2);
    }
}
