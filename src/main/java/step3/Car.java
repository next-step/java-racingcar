package step3;

import java.util.Random;

public class Car {

    private static final int RANDOM_BOUND = 10;
    private static final Random random = new Random();

    public int random() {
        return random.nextInt(RANDOM_BOUND);
    }

}
