package racingcar.utils;

import java.util.Random;

public class RandomGenerator {

    public static final int BOUND = 10;

    public static int randomNumber() {
        return new Random().nextInt(BOUND);
    }

}
