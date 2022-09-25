package step3.racinggame.core.gasstation;

import java.util.Random;

public class RandomGasStation implements GasStation {

    private static final int FUEL_SEED = 10;
    private final Random random = new Random();

    public int sellFuel() {
        return random.nextInt(FUEL_SEED);
    }
}
