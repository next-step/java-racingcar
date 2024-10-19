package racingcarcompetition;

import java.util.Random;

public class RandomNumber implements RandomGenerator {
    private final int endRange;

    public RandomNumber(int endRange) {
        this.endRange = endRange;
    }

    @Override
    public int generateRandom() {
        Random random = new Random();
        return random.nextInt(endRange);
    }
}
