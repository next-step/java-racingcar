package racing.domain.fuel;

import racing.domain.fuel.Fuel;
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
