package racingcar;

import java.util.Random;

public class RandomNumber {
    private static int RANDOM_BOUND = 10;
    private static Random random = new Random();

    public int getRandom () {
        return random.nextInt(RANDOM_BOUND);
    }
}
