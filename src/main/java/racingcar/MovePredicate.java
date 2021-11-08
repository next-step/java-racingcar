package racingcar;

import java.util.function.Predicate;

public class MovePredicate implements Predicate<Integer> {
    private static int THRESHOLD = 3;

    @Override
    public boolean test(Integer value) {
        return value > THRESHOLD;
    }
}
