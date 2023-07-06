package racing.utils;

import java.util.Random;

public class MockNotMoveRandom extends Random {

    private final int criterion;

    MockNotMoveRandom(final int criterion) {
        this.criterion = criterion;
    }

    @Override
    public int nextInt(final int bound) {
        return criterion - 1;
    }
}
