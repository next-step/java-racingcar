package racingcar.movablestrategy;

import java.util.Random;

public class RandomRacingStrategy implements MovableStrategy {
    private final int RANGE_FROM_ONE = 10;
    private final int MOVE_CONDITION = 4;

    @Override
    public boolean movable() {
        Random random = new Random();
        return random.nextInt(RANGE_FROM_ONE) >= MOVE_CONDITION;
    }
}
