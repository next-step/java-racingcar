package racing;

import java.util.Random;

public class RandomGenerator {
    private Random random;
    private static final int BOUND = 10;
    private static final int MOVE_BASE = 4;

    public RandomGenerator() {
        random = new Random();
    }

    public int create() {
        return random.nextInt(BOUND);
    }

    public boolean setMovable(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }
}
