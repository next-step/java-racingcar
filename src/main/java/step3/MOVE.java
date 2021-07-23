package step3;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum MOVE {
    GO((num) -> num >= 4),
    STOP((num) -> num < 4);

    private final Predicate<Integer> condition;

    MOVE(Predicate<Integer> condition) { this.condition = condition; }

    public static MOVE fromInt(int num) {
        return Stream.of(values()).filter(t -> t.condition.test(num)).findFirst().get();
    }
}
