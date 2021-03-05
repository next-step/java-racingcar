package racing;

import java.util.Random;

public class RandomlyMovingCar extends Car {

    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESHOLD = 5;
    private final Random random = new Random();

    public RandomlyMovingCar() {
        super();
    }

    @Override
    public void move() {
        if (random.nextInt(RANDOM_BOUND) < MOVE_THRESHOLD) {
            return;
        }

        super.move();
    }
}
