package racingGame.util;

import java.util.Random;

public class Lottery {
    private static Random random = new Random();
    private static int RANDOM_BOUNDARY = 10;

    public static int getLotteryNumber() {
        return random.nextInt(RANDOM_BOUNDARY);
    }
}
