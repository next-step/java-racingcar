package racingcar.domain;

import java.util.Random;

public class RandomEngine implements Engine {

    private static final int BOUNDARY = 4;
    private static final int END_OF_RANGE = 10;
    private static final Random random = new Random();

    protected RandomEngine() {
    }

    @Override
    public boolean movable() {
        return createRandom() >= BOUNDARY;
    }

    public int createRandom() {
        return random.nextInt(END_OF_RANGE);
    }
}
