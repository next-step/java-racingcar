package study.step3;

import java.util.Random;

public class RandomGenerator {

    static final int RANDOM_NUMBER_RANGE = 10;

    public int getRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_RANGE);
    }
}
