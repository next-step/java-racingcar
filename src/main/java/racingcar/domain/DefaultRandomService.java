package racingcar.domain;

import java.util.Random;

public class DefaultRandomService implements RandomService {

    private final Random random;

    public DefaultRandomService(Random random) {
        this.random = random;
    }

    @Override
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
