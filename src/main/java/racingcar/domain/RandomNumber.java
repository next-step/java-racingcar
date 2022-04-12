package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private final Random random = new Random();
    private static final int MAXVALUE = 10;

    public int createRandomNumber() {
        return random.nextInt(MAXVALUE);
    }
}
