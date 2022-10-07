package RacingCar.domain;

import java.util.Random;

public class RandomNumber implements Number {
    private static final Random random = new Random();

    public int random(int range) {
        return random.nextInt(range);
    }
}
