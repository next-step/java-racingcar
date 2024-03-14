package racingCar.interf;

import racingCar.utils.RandomGenerator;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int THRESHOLD = 4;
    private final RandomGenerator randomGenerator;
    public RandomMovingStrategy(RandomGenerator randomGenerator){
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean isMove() {
        return randomGenerator.generate() >= THRESHOLD;
    }
}
