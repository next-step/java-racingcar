package racingcar.domain;

import java.util.Random;

public class RandomCarMoveCondition implements CarMoveCondition {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND = 10;

    @Override
    public boolean movable() {
        return RANDOM.nextInt(RANDOM_BOUND) >= 4;
    }

}
