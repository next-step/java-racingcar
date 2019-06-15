package calculator;

import java.util.*;
import java.util.function.IntBinaryOperator;

enum Operator {

    PLUS('+', (num1, num2) -> num1 + num2),
    MINUS('-', (num1, num2) -> num1 - num2),
    MULTIPLY('*', (num1, num2) -> num1 * num2),
    DIVIDE('/', (num1, num2) -> {
        validateDivision(num2);
        return num1 / num2;
    });

    private final char symbol;
    private final IntBinaryOperator expression;

    Operator(char symbol, IntBinaryOperator expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public int calculator(int num1, int num2) {
        return expression.applyAsInt(num1, num2);
    }

    private static void validateDivision(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    public static Operator from(String symbol) {
        return EnumSet.allOf(Operator.class).stream()
                .filter(operator -> operator.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(symbol + "은 지원하지 않는 연산기호입니다."));
    }

    public String getSymbol() {
        return String.valueOf(symbol);
    }

    @Override
    public String toString() {
        return this.name() + "{"
                + "symbol=" + symbol
                + ", expression=" + expression + '}';
    }
}
