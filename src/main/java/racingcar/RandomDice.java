package racingcar;

import java.util.Random;

public final class RandomDice {
    private static final int RANDOM_SIZE = 10;

    private static Random random = new Random();

    public static int getRandomValue() {
        return random.nextInt(RANDOM_SIZE);
    }
}
