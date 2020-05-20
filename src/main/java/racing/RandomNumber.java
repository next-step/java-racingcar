package racing;

import java.util.Random;

public class RandomNumber {
    private static Random random = new Random();
    private static int boundNumber = 10;

    public static int getRandomNumber() {
        return random.nextInt(boundNumber);
    }


}
