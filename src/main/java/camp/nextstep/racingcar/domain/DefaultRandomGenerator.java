package camp.nextstep.racingcar.domain;

import java.util.Random;

public class DefaultRandomGenerator implements RandomGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public int generate() {
        return RANDOM.nextInt(10);
    }
}
