package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

    ADDITION("+", (x, y) -> x + y),
    SUBTRACTION("-", (x, y) -> x - y),
    MULTIPLICATION("*", (x, y) -> x * y),
    DIVISION("/", (x, y) -> x / y);

    String symbol;
    BinaryOperator<Integer> calculation;

    Operator(String symbol, BinaryOperator<Integer> calculation) {
        this.symbol = symbol;
        this.calculation = calculation;
    }

    public static Operator createOperator(String str) {
        return Arrays.stream(Operator.values())
                     .filter(operator -> operator.symbol.equals(str))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다. 사칙 연산자를 사용해주세요."));
    }

}
