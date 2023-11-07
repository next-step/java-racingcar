package racingcar.service;

import java.util.*;

public class RandomNumber {

    private static final int RANDOM_RANGE = 10;
    private static final Random RANDOM = new Random();

    public static int getRandomNumber() {
        return RANDOM.nextInt(RANDOM_RANGE);
    }
}
