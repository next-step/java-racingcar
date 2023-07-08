package racing.utils;

import java.util.Random;

public final class MockNotMoveRandom extends Random {

    private final int criterion;

    public MockNotMoveRandom() {
        this(0);
    }

    public MockNotMoveRandom(final int criterion) {
        this.criterion = criterion;
    }

    @Override
    public int nextInt(final int bound) {
        return criterion - 1;
    }
}
