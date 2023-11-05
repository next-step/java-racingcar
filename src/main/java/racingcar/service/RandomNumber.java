package racingcar.service;

import java.util.*;

public class RandomNumber {

    private static final Random RANDOM = new Random();
    public static int getRandomNumber() {
        return RANDOM.nextInt(10);
    }
}
