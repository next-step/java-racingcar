package step3;

import java.util.Random;

public class Car {

    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MIN_MOVE_CONDITION = 4;
    private static final Random RANDOM = new Random();
    private int location;

    public Car() {
        this.location = 0;
    }

    public int getLocation() {
        return location;
    }

    public void go() {
        int distance = RANDOM.nextInt(MAX_RANDOM_NUMBER);
        if (distance >= MIN_MOVE_CONDITION) {
            location += distance;
        }
    }
}
