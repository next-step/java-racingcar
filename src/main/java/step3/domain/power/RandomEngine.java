package step3.domain.power;

import java.util.Random;

public class RandomEngine implements Engine {

    private static final int POWER_BOUNDARY = 10;
    private static final Random random = new Random();

    @Override
    public int generatePower() {
        return random.nextInt(POWER_BOUNDARY);
    }
}
