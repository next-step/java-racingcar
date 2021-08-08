package racingcar;

import java.util.Random;

public class RandomNumGenerator {
    private final static int MAX_RANDOM_NUMBER = 10;
    public int getRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER);
    }
}
