package racingGame;

import java.util.Random;

public class RandomNumber {

    public static final int RANDOM_NUMBER_BOUND = 10;

    public static int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
