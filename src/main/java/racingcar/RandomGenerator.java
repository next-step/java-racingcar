package racingcar;

import java.util.Random;

public class RandomGenerator extends Random {

    private static final int RANDOM_ARRANGE = 10;

    @Override
    public int nextInt() {
        return nextInt(RANDOM_ARRANGE);
    }
}
