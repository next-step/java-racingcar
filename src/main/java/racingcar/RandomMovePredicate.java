package racingcar;

import java.util.Random;

public class RandomMovePredicate implements MovePredicate {
    private static final int THRESHOLD = 4;

    @Override
    public boolean test() {
        return new Random().nextInt(10) >= THRESHOLD;
    }
}
