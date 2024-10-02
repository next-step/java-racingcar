package racingGame.model.numbergenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{

    private static final int CREATE_INTEGER_RANGE = 10;

    private Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int generateNumber() {
        return random.nextInt(CREATE_INTEGER_RANGE);
    }
}
