package domain;

import util.Common;

import java.util.Arrays;
import java.util.function.BiFunction;


public enum Operation {

    PLUS("+", (origin_number,number) -> origin_number + number),
    MINUS("-", (origin_number,number) -> origin_number - number),
    DIVISION("/", (origin_number,number) -> {

        if(number == 0 || (origin_number % number) !=0) {
            throw new ArithmeticException ("0으로 나눌수 없습니다.");
        }

        return origin_number / number;
    }),
    MULTIPLE("*", (origin_number,number) -> origin_number * number);

    private String mark;
    private BiFunction<Integer, Integer, Integer> expression;

    Operation(String mark, BiFunction<Integer, Integer,Integer> expression) {
        this.mark = mark;
        this.expression = expression;
    }

    public static Operation findByInputMark(String mark) {

        return Arrays.stream(Operation.values())
                .filter( operation -> Common.checkValue(mark))
                .filter( operation -> operation.getMark().equals(mark))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(Integer origin, String number) {
        int parseNumber = Integer.parseInt(number);
        return this.expression.apply(origin, parseNumber);
    }

    public String getMark() {
        return mark;
    }

}
