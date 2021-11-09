package study;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operator {
    ADD("+", InputNumber::add),
    SUBTRACT("-", InputNumber::subtract),
    MULTIPLY("*", InputNumber::multiply),
    DIVIDE("/", InputNumber::divide);

    private String symbol;
    private BiFunction<InputNumber, InputNumber, InputNumber> expression;

    Operator(String symbol, BiFunction<InputNumber, InputNumber, InputNumber> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public InputNumber calculate(InputNumber first, InputNumber second) {
        return expression.apply(first, second);
    }

    public static Operator getOperator(String symbol) {
        return Stream.of(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."));
    }
}
