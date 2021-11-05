package step3.domain.power;

import java.util.Random;

public class RandomPower implements Power {

    private static final int INTEGER_BOUND = 10;
    private static final Random random = new Random();

    @Override
    public int generatePower() {
        return random.nextInt(INTEGER_BOUND);
    }
}
