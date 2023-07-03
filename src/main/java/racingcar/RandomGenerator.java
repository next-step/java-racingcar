package racingcar;

import java.util.Random;

public class RandomGenerator {
    static final int min = 0;
    static final int max = 9;
    public static int generateNumber() {
        return new Random().nextInt(max + min) + min;
    }
}
