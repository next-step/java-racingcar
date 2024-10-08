package racingcar.utils;

import racingcar.domain.Movement;

import java.util.Random;

public class RandomMovement implements Movement {
    private static final int MOVE_CONDITION = 4;
    private final Random random = new Random();

    public boolean isMove() {
        return random.nextInt(10) >= MOVE_CONDITION;
    }
}
