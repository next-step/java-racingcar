package racingcar.movablestrategy;

import racingcar.Racing;

import java.util.Random;

public class RandomRacingStrategy implements MovableStrategy {
    private int rangeFromOne = Racing.RANDOM_NUMBER_RANGE;
    private int moveCondition = Racing.MOVE_CONDITION;

    @Override
    public boolean movable() {
        Random random = new Random();
        return random.nextInt(rangeFromOne) >= moveCondition;
    }
}
