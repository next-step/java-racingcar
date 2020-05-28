package carracing.domain;

import carracing.domain.car.RandomValueStrategy;

public class RandomMinValueStrategy extends RandomValueStrategy {

    @Override
    public boolean progress() {
        RandomValue randomValue = new RandomMinValue();
        return randomValue.getRandomValue() > RandomValueStrategy.MOVE_CHECK_VALUE;
    }
}
