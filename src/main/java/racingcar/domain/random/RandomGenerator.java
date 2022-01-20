package racingcar.domain.random;

import java.util.Random;

public class RandomGenerator implements RandomStrategy {

    private static final int LIMIT = 10;

    public int get() {
        return new Random().nextInt(LIMIT);
    }
}
