package racingcar.domain;

import racingcar.util.RandomGenerator;

public class RandomNumberMovingStrategy implements MovingStrategy{
    private static final int MIN_NUMBER = 4;
    private final RandomGenerator randomGenerator;

    public RandomNumberMovingStrategy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean isMove() {
        return randomGenerator.generator() >= MIN_NUMBER;
    }
}
