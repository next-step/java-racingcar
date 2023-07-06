package racing.utils;

import java.util.Random;

public class RandomFactory {

    public static Random createMoveRandom(final int criterion) {
        return new MockMoveRandom(criterion);
    }

    public static Random createNotMoveRandom(final int criterion) {
        return new MockNotMoveRandom(criterion);
    }
}
