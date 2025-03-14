package carracing;

import java.util.Random;

public class Car {
    public static final int SEED = 50;
    Random random = new Random(SEED);

    public boolean canMove() {
        return random.nextInt(10) >= 4;
    }
}
