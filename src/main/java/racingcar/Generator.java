package racingcar;

import java.util.Random;

public class Generator {
    static final int min = 0;
    static final int max = 9;
    public static int generateRandomNumber() {
        return new Random().nextInt(max + min) + min;
    }
}
