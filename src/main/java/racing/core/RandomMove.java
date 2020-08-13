package racing.core;

import java.util.Random;

public class RandomMove implements Move {

    public static final int TOTAL_CASES = 10;
    public static final int CONDITION = 4;

    private Random random = new Random();

    @Override
    public boolean canMove() {
        return random.nextInt(TOTAL_CASES) >= CONDITION;
    }
}
