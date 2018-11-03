package racing;

import java.util.Random;

public class RandomMoveGenerator {
    private Random random = null;

    public static final int MAX_MOVE_SIZE = 10;

    public RandomMoveGenerator() {
        this.random = new Random();
    }

    public int generate() {
        return random.nextInt(MAX_MOVE_SIZE);
    }
}
