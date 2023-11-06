package racinggame.domain.strategy;

import java.util.Random;

public class TenBoundRandomHolder implements RandomHolder {

    public static final int DEFAULT_BOUND = 10;
    private final Random random = new Random();

    @Override
    public int nextInt() {
        return random.nextInt(DEFAULT_BOUND);
    }
}
