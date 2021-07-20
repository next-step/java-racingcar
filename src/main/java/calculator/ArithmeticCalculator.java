package calculator;

import java.util.function.BiFunction;

import static java.util.Arrays.stream;

enum ArithmeticCalculator {
    ADDITION("+", (x, y) -> x + y),
    SUBTRACTION("-", (x, y) -> x - y),
    MULTIPLICATION("*", (x, y) -> x * y),
    DIVISION("/", (x, y) -> x / y);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> function;

    ArithmeticCalculator(String operator, BiFunction<Integer, Integer, Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public static int apply(String operator, int x, int y) {
        if(isDivideByZero(operator, y)) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .get()
                .function.apply(x, y);
    }

    private static boolean isDivideByZero(String operator, int y) {
        return operator.equals(DIVISION.operator) && y == 0;
    }
}
