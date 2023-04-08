package racingcar;

import java.util.Random;

public class NumberRange {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    public static int getOne() {
        return new Random().nextInt(10);
    }
}
