package racing.domain.car.vo.fuel;

import util.RandomUtils;

public final class RandomFuel implements Fuel {
    @Override
    public int value() {
        return RandomUtils.nextInt(Fuel.MAX_VALUE);
    }
}
