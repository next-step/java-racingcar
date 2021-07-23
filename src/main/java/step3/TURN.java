package step3;

import step2.Operator;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum TURN {
    GO((num) -> num >= 4),
    STOP((num) -> num < 4);

    private final Predicate<Integer> condition;

    TURN(Predicate<Integer> condition) {
        this.condition = condition;
    }

    public static TURN fromInt(int num) {
        return Stream.of(values()).filter(t -> t.condition.test(num)).findFirst().get();
    }
}
