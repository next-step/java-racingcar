package racing;

import java.util.Random;

public class CountGenerator {
    public static int getRandomInt(int bound) {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(bound);
    }
}
