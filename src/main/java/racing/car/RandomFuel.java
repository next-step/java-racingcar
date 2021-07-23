package racing.car;

import util.RandomUtils;

public class RandomFuel extends Fuel {
    @Override
    public boolean isMovable(int requireFuelValue) {
        return RandomUtils.nextInt(Fuel.FULL.value) >= requireFuelValue;
    }
}
