package step3.racinggame.core;

import java.util.Random;

public class GasStation {

    private static final int FUEL_SEED = 10;
    private static final Random random = new Random();

    public static int sellFuel() {
        return random.nextInt(FUEL_SEED);
    }
}
