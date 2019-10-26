package racing;

import java.util.Random;

public class CountGenerator {
    private static Random random = new Random(System.currentTimeMillis());

    public static int getRandomInt() {
        return random.nextInt();
    }
}
