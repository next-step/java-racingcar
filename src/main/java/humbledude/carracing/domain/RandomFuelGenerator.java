package humbledude.carracing.domain;

import java.util.Random;

public class RandomFuelGenerator implements FuelGenerator {

    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}
