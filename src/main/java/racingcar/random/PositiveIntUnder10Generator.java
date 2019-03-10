package racingcar.random;

import java.util.Random;

public class PositiveIntUnder10Generator implements RandomIntGenerator {
    private static final int BOUND = 10;

    @Override
    public int getRandomInt() {
        return new Random().nextInt(BOUND);
    }
}
