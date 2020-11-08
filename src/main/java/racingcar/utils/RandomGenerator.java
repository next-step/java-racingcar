package racingcar.utils;

import java.util.Random;

public class RandomGenerator {

    private final Random random = new Random();

    public Integer generatorNumber(int bound) {
        return random.nextInt(bound);
    }

}
