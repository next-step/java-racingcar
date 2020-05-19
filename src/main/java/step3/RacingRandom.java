package step3;

import java.util.Random;

public class RacingRandom {

    private Random random;

    public RacingRandom() {
        random = new Random();
    }

    public int getRandomNumber() {
        return random.nextInt(10);
    }
}

