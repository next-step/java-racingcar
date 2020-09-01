package racingcar.utils;

import java.util.Random;

import static racingcar.utils.Constants.RANDOM_BOUND;

public class RandomInt {

    public static Random random = new Random();

    public static int returnRandom() {
        return random.nextInt(RANDOM_BOUND);
    }

}
