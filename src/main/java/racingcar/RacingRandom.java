package racingcar;

import java.util.Random;


public class RacingRandom {

    public static final int LIMIT = 10;
    private static final Random random = new Random();

    public static RandomNo getRandomNo() {
        return new RandomNo(random.nextInt(LIMIT));
    }
}
