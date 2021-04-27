package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Opperation{
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Opperation(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static void findBySymbol(String symbol){
        System.out.println(Arrays.stream(Opperation.values()));
    }

}
