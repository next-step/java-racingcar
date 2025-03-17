package racingcar.strategy;

import racingcar.generator.RandomGenerator;

public class RandomStrategy implements MovingStrategy {

    private static final int RANDOM_MIN_NUMBER = 4;
    private final RandomGenerator randomGenerator;

    public RandomStrategy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean isMove() {
        return randomGenerator.generate() >= RANDOM_MIN_NUMBER;
    }


}
