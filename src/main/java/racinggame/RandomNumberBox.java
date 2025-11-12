package racinggame;

import java.util.Random;

public class RandomNumberBox {
    private static final int RANDOM_MAX_NUM = 9;
    private static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(RANDOM_MAX_NUM);
    }

}
