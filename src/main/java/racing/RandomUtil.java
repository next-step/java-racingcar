package racing;

import java.util.Random;

public class RandomUtil {

    private static final int DEFAULT_BOUND = 10;

    public static int getRandomNumUnder10() {
        Random random = new Random();
        return random.nextInt(DEFAULT_BOUND);
    }
}
