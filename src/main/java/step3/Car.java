package step3;

import java.util.Random;

public class Car {
    private static final int RANDOM_BOUND = 10;
    private static final int RACE_THRESHOLD = 4;
    private static final Random random = new Random();

    private final StringBuilder distance;

    public Car() {
        this.distance = new StringBuilder();
    }

    public void printCurrentDistance() {
        System.out.println(this.distance);
    }

    public void race() {
        if (random.nextInt(RANDOM_BOUND) >= RACE_THRESHOLD) {
            distance.append("-");
        }
        printCurrentDistance();
    }
}
