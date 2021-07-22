package racing.domain;

import racing.util.RandomNumber;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int THRESHOLD_NUMBER = 4;
    private final RandomNumber randomNumber;

    public RandomMovingStrategy(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public boolean isMove() {
        return randomNumber.create() >= THRESHOLD_NUMBER;
    }
}
