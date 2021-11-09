package study;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operator {
    ADD("+", InputNumber::add),
    SUBTRACT("-", InputNumber::subtract),
    MULTIPLY("*", InputNumber::multiply),
    DIVIDE("/", InputNumber::divide);

    private final String symbol;
    private final BiFunction<InputNumber, InputNumber, InputNumber> expression;

    Operator(String symbol, BiFunction<InputNumber, InputNumber, InputNumber> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static InputNumber calculate(InputNumber first, InputNumber second, String symbol) {
        return getOperator(symbol).calculate(first, second);
    }

    private InputNumber calculate(InputNumber first, InputNumber second) {
        return expression.apply(first, second);
    }

    private static Operator getOperator(String symbol) {
        return Stream.of(Operator.values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."));
    }
}
