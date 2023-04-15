package racingcar;

import java.util.Random;

public class RandomGenerator {

    public static final int BOUND = 10;

    public int getRandomNumber() {
        return new Random().nextInt(BOUND);
    }

}
