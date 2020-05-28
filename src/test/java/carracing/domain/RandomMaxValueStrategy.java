package carracing.domain;

import carracing.domain.car.ProgressStrategy;
import carracing.domain.car.RandomValueStrategy;

public class RandomMaxValueStrategy extends RandomValueStrategy {

    @Override
    public boolean progress() {
        RandomValue randomValue = new RandomMaxValue();
        return randomValue.getRandomValue() > RandomValueStrategy.MOVE_CHECK_VALUE;
    }
}
