package step3;

import java.util.Random;

public class RacingCar {
    private static final Random random = new Random();

    public int getRandomInt() {
        return random.nextInt(10);
    }
}
