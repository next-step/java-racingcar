package util.calculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public enum Operator {
    ADD("+", (leftNumber, rightNumber) -> leftNumber + rightNumber),
    MIN("-", (leftNumber, rightNumber) -> leftNumber - rightNumber),
    MUL("*", (leftNumber, rightNumber) -> leftNumber * rightNumber),
    DIV("/", (leftNumber, rightNumber) -> leftNumber / rightNumber);

    private final String sign;
    private final BiFunction<Integer, Integer, Integer> handler;

    Operator(String sign, BiFunction<Integer, Integer, Integer> handler) {
        this.sign = sign;
        this.handler = handler;
    }

    public int calculation(int num1, int num2) {
        return handler.apply(num1, num2);
    }

    public static Optional<Operator> of(String input) {
        return Arrays.stream(values())
                .filter(
                        i -> i.sign.equals(input)
                ).findFirst();
    }
}
