package racingcar;

import java.util.Random;

public class RandomValue {

    private int value = 0;

    public static int getValue() {
        return new Random().nextInt(10);
    }
}
