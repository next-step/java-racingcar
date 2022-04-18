package racingCar;

import java.util.Random;

public class RandomInteger {
    static Random random = new Random();
    static final int BOUND = 10;

    public static int next() {
        return random.nextInt(BOUND);
    }
}
