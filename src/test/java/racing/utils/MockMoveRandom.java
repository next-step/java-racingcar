package racing.utils;

import java.util.Random;

public final class MockMoveRandom extends Random {

    private final int criterion;

    public MockMoveRandom(final int criterion) {
        this.criterion = criterion;
    }

    @Override
    public int nextInt(final int bound) {
        return criterion;
    }
}
