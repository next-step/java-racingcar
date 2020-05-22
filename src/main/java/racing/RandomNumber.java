package racing;

import java.util.Random;

public class RandomNumber {
    private static Random random = new Random();
    private static final int BoundNumber = 10;

    public static int getRandomNumber() {
        return random.nextInt(BoundNumber);
    }
}
