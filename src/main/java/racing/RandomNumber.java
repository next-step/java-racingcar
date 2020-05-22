package racing;

import java.util.Random;

public class RandomNumber {
    private static Random random = new Random();
    
    public static int getRandomNumber(int bound) {
        return random.nextInt(bound);
    }
}
