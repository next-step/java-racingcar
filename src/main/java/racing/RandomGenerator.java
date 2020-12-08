package racing;

import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();
    public static int getRandomNumber() {
        int number = random.nextInt(10);
        return number;
    }
}