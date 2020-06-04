package racingcar_step4.model;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{

    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_POSSIBLE_VALUE = 4;

    @Override
    public boolean isMove() {
        return new Random().nextInt(RANDOM_RANGE) >= MOVE_POSSIBLE_VALUE;
    }
}
