package racingcar;

import java.util.Random;

public class RandomNumber {
    private final static int MAX_RANDOM_NUMBER = 10;
    public int getRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER);
    }
}
