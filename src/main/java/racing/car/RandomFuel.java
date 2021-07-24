package racing.car;

import util.RandomUtils;

public class RandomFuel extends Fuel {
    public RandomFuel() {
        super(Fuel.MAX_VALUE);
    }

    @Override
    public int value() {
        return RandomUtils.nextInt(super.value());
    }
}
