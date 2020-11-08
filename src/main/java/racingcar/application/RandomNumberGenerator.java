package racingcar.application;

import java.util.Random;

public class RandomNumberGenerator {

    private final Random random = new Random();

    public Integer generatorNumber(int bound) {
        return random.nextInt(bound);
    }

}
