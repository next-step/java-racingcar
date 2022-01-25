package racingcar.domain.car;

import java.util.Random;

public class RandomEngine implements Engine {

    private static final int BOUNDARY = 4;
    private static final int END_OF_RANGE = 10;
    private static final Random random = new Random();

    public RandomEngine() {
    }

    @Override
    public boolean movable() {
        return createRandom() >= BOUNDARY;
    }

    private int createRandom() {
        return random.nextInt(END_OF_RANGE);
    }
}
