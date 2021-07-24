package racing.domain.fuel;

import util.RandomUtils;

import java.util.Objects;

public final class RandomFuel implements Fuel {
    private static final Object syncObject = new Object();
    private static RandomFuel instance;

    private RandomFuel() {}

    public static RandomFuel getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (syncObject) {
                if (Objects.isNull(instance))
                    instance = new RandomFuel();
            }
        }
        return instance;
    }

    @Override
    public int value() {
        return RandomUtils.nextInt(Fuel.MAX_VALUE);
    }
}
