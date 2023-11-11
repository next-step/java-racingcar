package racingcar.movablestrategy;

import java.util.Random;

public class RandomRacingStrategy implements MovableStrategy {
    private int rangeFromOne = 10;
    private int moveCondition = 4;

    @Override
    public boolean movable() {
        Random random = new Random();
        return random.nextInt(rangeFromOne) >= moveCondition;
    }
}
