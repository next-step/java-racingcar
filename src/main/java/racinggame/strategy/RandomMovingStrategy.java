package racinggame.strategy;

import racinggame.util.RandomNumber;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MOVABLE_NUMBER = 4;
    private final RandomNumber randomNumber;

    public RandomMovingStrategy(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public boolean isMove() {
        return randomNumber.createBetweenZeroToNine() >= MOVABLE_NUMBER;
    }
}
