package racing;

import java.util.Random;

public class RandomNumberFactory {

    private static final Random random = new Random();
    private static final int MAX_NUMBER = 10;

    public static int createRandomNumber() {
        return random.nextInt(MAX_NUMBER);
    }
}
