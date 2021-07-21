package step2;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Operator {
    ADD("+") {
        public int apply(int num1, int num2) { return num1 + num2; }
    },
    SUBTRACT("-") {
        public int apply(int num1, int num2) { return num1 - num2; }
    },
    MULTIPLY("*") {
        public int apply(int num1, int num2) { return num1 * num2; }
    },
    DIVIDE("/") {
        public int apply(int num1, int num2) { return num1 / num2; }
    };

    private final String character;

    private static final Map<String, Operator> stringToEnum =
            Stream.of(values()).collect(
                    toMap(Object::toString, e -> e)
            );

    Operator(String character) { this.character = character; }

    @Override public String toString() { return character; }

    public static Operator fromString(String character) {
        return stringToEnum.get(character);
    }

    public abstract int apply(int num1, int num2);
}
