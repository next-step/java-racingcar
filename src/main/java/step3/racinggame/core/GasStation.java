package step3.racinggame.core;

import java.util.Random;

public class GasStation {

    private static final int FUEL_SEED = 10;
    private final Random random;

    public GasStation() {
        random = new Random();
    }

    public int sellFuel() {
        return random.nextInt(FUEL_SEED);
    }
}
