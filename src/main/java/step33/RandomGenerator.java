package step33;

import java.util.Random;

public class RandomGenerator{

    public static final int RANDOM_RANGE = 10;
    public static final int POSSIBLE_MOVE_NUMBER = 3;

    private Random random;

    public RandomGenerator(Random random) {
        this.random = random;
    }

    public int getRandomNumber() {
        return random.nextInt(RANDOM_RANGE);
    }

    public boolean isOver(int randomNumber) {
        if (randomNumber > POSSIBLE_MOVE_NUMBER) {
            return true;
        }
        return false;
    }
}
