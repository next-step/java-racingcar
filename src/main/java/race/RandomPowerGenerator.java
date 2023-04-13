package race;

import java.util.Random;

public class RandomPowerGenerator implements PowerGenerator {
    private static final int MAX_POWER_BOUND = 10;

    @Override
    public int generate() {
        return new Random().nextInt(MAX_POWER_BOUND);
    }
}
