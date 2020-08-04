package domain;

import java.util.Arrays;
import java.util.function.BiFunction;


public enum Operation {

    PLUS("+", (originNumber, number) -> originNumber + number),
    MINUS("-", (originNumber, number) -> originNumber - number),
    DIVISION("/", (originNumber, number) -> {

        if (number == 0 || (originNumber % number) != 0) {
            throw new ArithmeticException("0으로 나눌수 없습니다.");
        }

        return originNumber / number;
    }),
    MULTIPLE("*", (originNumber, number) -> originNumber * number);

    private final String mark;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operation(String mark, BiFunction<Integer, Integer, Integer> expression) {
        this.mark = mark;
        this.expression = expression;
    }

    public static Operation findByInputMark(String mark) {

        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getMark().equals(mark))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(Integer origin, String number) {
        int parseNumber = Integer.parseInt(number);
        return expression.apply(origin, parseNumber);
    }

    public String getMark() {
        return mark;
    }

}
