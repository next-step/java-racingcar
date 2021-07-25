package racing.domain.car.vo.fuel;

import java.util.Random;

public final class RandomFuel implements Fuel {
    private static final Random random = new Random();

    @Override
    public int value() {
        return random.nextInt(Fuel.MAX_VALUE);
    }
}
