package racing.utils;

import java.util.Random;

public class MockMoveRandom extends Random {

    private final int criterion;

    MockMoveRandom(final int criterion) {
        this.criterion = criterion;
    }

    @Override
    public int nextInt(final int bound) {
        return criterion;
    }
}
