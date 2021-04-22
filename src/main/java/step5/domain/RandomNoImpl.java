package step5.domain;

import java.util.Random;

public class RandomNoImpl implements RandomNo{

    private static Random random;

    public boolean isMovable() {
        return 4 <= random.nextInt(10);
    }
}
