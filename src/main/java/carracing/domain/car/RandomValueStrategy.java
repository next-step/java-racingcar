package carracing.domain.car;

import carracing.domain.RandomValue;

public class RandomValueStrategy implements ProgressStrategy {

    protected static final int  MOVE_CHECK_VALUE = 4;

    @Override
    public boolean progress() {
        RandomValue randomValue = new RandomValue();
        return randomValue.getRandomValue() > MOVE_CHECK_VALUE;
    }
}