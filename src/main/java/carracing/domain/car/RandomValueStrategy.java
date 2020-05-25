package carracing.domain.car;

import carracing.domain.RandomValue;

public class RandomValueStrategy implements ProgressStrategy {

    RandomValue randomValue;
    private final int  MOVE_CHECK_VALUE = 4;

    public RandomValueStrategy(RandomValue randomValue) {
        this.randomValue = randomValue;
    }

    @Override
    public boolean progress() {
        return randomValue.getRandomValue() > MOVE_CHECK_VALUE;
    }
}
