package racinggame.strategy;

import java.util.Random;

public class RandomNumber implements GenerateNumber {

    private static final Random random = new Random();
    private static final int LIMIT_NUMBER = 10;

    @Override
    public int number() {
        return random.nextInt(LIMIT_NUMBER);
    }

}
