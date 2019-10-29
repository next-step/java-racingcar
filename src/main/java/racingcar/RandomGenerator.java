package racingcar;

import java.util.Random;

public class RandomGenerator {

    private static Random random = new Random();

    public static int getRandomInteger(int bound) {
        return random.nextInt(bound);
    }

}
