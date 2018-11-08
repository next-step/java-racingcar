package racingcar;

import java.util.Random;

public class RandomProvider {
    private static final int RANDOM_MAX_SIZE = 10;

    public int getRandom() {
        return new Random().nextInt(RANDOM_MAX_SIZE);
    }
}
