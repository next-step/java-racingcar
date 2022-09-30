package step3;

import java.util.Random;

public class Car {

    private int location;

    private static final int RANDOM_BOUND = 10;

    private static final int THRESHOLD = 4;

    private static final Random random = new Random();

    public Car() {
        this.location = 0;
    }

    public int location() {
        return this.location;
    }

    public void moveOrStop() {
        if (random.nextInt(RANDOM_BOUND) >= THRESHOLD) {
            location++;
        }
    }
}
