package step3.domain;

import java.util.Random;

public class RandomNumber {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;

    public int randomNumber() {
        return RANDOM.nextInt(BOUND);
    }
}
