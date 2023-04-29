package racingcar.numbergenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{

    private final static int BOUND_NUMBER = 10;
    private final static Random random = new Random();
    @Override
    public int generate() {
        return random.nextInt(BOUND_NUMBER);
    }
}
