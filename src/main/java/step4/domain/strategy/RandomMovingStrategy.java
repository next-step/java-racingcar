package step4.domain.strategy;

import step4.domain.RandomGenerator;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int ADVANCE_MIN_NUMBER = 4;
    private final RandomGenerator randomGenerator;


    public RandomMovingStrategy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean isMove() {
        return randomGenerator.generate() >= ADVANCE_MIN_NUMBER;
    }

}
