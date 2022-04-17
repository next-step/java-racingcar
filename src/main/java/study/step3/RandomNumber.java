package study.step3;

import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();
    private final int BOUND = 10;

    public int generateRandomNumber() {
        return random.nextInt(BOUND);
    }

}
