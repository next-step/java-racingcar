package step2;

import java.util.Map;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Operator implements IntBinaryOperator {
    ADD("+", Integer::sum),
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private final String character;
    public final IntBinaryOperator apply;

    private static final Map<String, Operator> stringToEnum =
            Stream.of(values()).collect(
                    toMap(Object::toString, e -> e)
            );

    Operator(String character, IntBinaryOperator apply) {
        this.character = character;
        this.apply = apply;
    }

    @Override public String toString() { return character; }

    public static Operator fromString(String character) {
        return stringToEnum.get(character);
    }

    @Override
    public int applyAsInt(int left, int right) { return apply.applyAsInt(left, right); }
}
