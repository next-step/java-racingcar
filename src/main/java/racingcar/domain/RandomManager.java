package racingcar.domain;

import java.util.Random;

public class RandomManager {

    private static final int LIMIT = 10;

    public static int get() {
        return new Random().nextInt(LIMIT);
    }
}
