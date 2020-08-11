package racingcar;

import java.util.Random;

public class RandomMove {
    private static final int STANDARD_MOVEMENT = 4;
    private static final int RANDOM_BOUND = 10;

    private final Random random = new Random();

    private final int standard;
    private final int bound;

    public RandomMove() {
        this(STANDARD_MOVEMENT, RANDOM_BOUND);
    }

    public RandomMove(int standard, int bound) {
        this.standard = standard;
        this.bound = bound;
    }

    public boolean canMove() {
        int randomNum = random.nextInt(bound);
        if(randomNum >= standard) {
            return true;
        }
        return false;
    }

}
