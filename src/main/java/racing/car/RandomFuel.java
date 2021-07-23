package racing.car;

import util.RandomUtils;

public class RandomFuel extends Fuel {
    public RandomFuel() {
        super(Fuel.EMPTY.value);
    }

    @Override
    public boolean isMovable(int requireFuelValue) {
        return RandomUtils.nextInt(Fuel.FULL.value) >= requireFuelValue;
    }
}
