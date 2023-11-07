package racingCar.movableStrategy;

import racingCar.movableStrategy.MovableStrategy;

import java.util.Random;

public class RandomStrategy implements MovableStrategy {
    private int rangeFromOne;
    private int moveCondition;
    public RandomStrategy(int moveCondition, int rangeFromOne) {
        this.moveCondition = moveCondition;
        this.rangeFromOne = rangeFromOne;
    }
    @Override
    public boolean movable() {
        Random random = new Random();
        return random.nextInt(rangeFromOne) >= moveCondition;
    }
}
