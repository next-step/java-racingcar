package racingcar;

import java.util.Random;

public class RandomGenerator {

    public static int getRandomInteger(int bound) {
        return new Random().nextInt(bound);
    }
}
