package race;

import java.util.Random;

public class ExtractRandom {
    private static Random random = new Random();
    private static final int BOUND = 10;

    public int getRandomNumber() {
        return random.nextInt(BOUND);
    }
}
