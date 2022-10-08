package step4.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MAX_BOUND_NUMBER = 10;

    private static final Random random = new Random();

    public int generateNumber(){
        return random.nextInt(MAX_BOUND_NUMBER);
    }
}
