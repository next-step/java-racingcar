package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        if (y == 0) {
            throw new ArithmeticException("0으로는 나눌 수 없습니다.");
        }
        return x / y;
    }

    ),
    ;

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operatorFunc;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operatorFunc) {
        this.symbol = symbol;
        this.operatorFunc = operatorFunc;
    }

    public static Operator findBySymbol(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 연산자입니다."));
    }

    public int execute(int x, int y) {
        return operatorFunc.apply(x, y);
    }
}
