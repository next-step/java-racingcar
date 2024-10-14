package step4racinggamewinner.random;

import java.util.Random;

public class RacingCarRandomGenerator implements RandomGenerator {
    @Override
    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
