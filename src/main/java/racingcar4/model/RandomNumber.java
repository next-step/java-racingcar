package racingcar4.model;

import java.util.Random;

public class RandomNumber {

    private static final int RANDOM_VALUE_RANGE = 10;

    public static int getNumber() {
        return new Random().nextInt(RANDOM_VALUE_RANGE);
    }
}
