package step3;

import java.util.Random;

public class RandomMoving implements Moving {
    public static final int BOUND = 10;
    private final Random random = new Random();

    @Override
    public boolean canMove() {
        return random.nextInt(BOUND) >= 4;
    }
}
