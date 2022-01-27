package calculator;

import java.util.Arrays;
import java.util.function.ToIntBiFunction;

public enum Operator {
    ADD("+", (x, y) -> x + y),
    SUBTRACT("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final ToIntBiFunction<Integer, Integer> calculator;

    Operator(String symbol,
        ToIntBiFunction<Integer, Integer> calculator) {
        this.symbol = symbol;
        this.calculator = calculator;
    }

    public static Operator findBySymbol(String symbol) {
        return Arrays.stream(values()).filter(val -> val.symbol.equals(symbol)).findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    public int operate(int leftOperand, int rightOperand) {
        return calculator.applyAsInt(leftOperand, rightOperand);
    }
}

