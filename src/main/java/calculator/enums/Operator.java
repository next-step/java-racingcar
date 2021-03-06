package calculator.enums;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (number1, number2) -> number1 + number2),
    SUBTRACT("-", (number1, number2) -> number1 - number2),
    MULTIPLY("*", (number1, number2) -> number1 * number2),
    DIVIDE("/", (number1, number2) -> {
        validateDivisionByZero(number2);
        return number1 / number2;
    });

    private static int ZERO = 0;
    private String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static Operator findBySymbol(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> symbol.equals(operator.getSymbol()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호를 확인해주세요."));
    }

    private static void validateDivisionByZero(int number) {
        if (number == ZERO) {
            throw new IllegalArgumentException("\"/\"이 0으로 나누어지는지 확인해주세요.");
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public int calculate(int number1, int number2) {
        return expression.apply(number1, number2);
    }
}