package racingcar;

import java.util.Random;

public class RacingCar {

    private Random random;
    private static final int MIN_RANDOM_NUM_CAN_MOVED = 4;

    private final int MOVE_LENGTH = 1;
    private int position = 0;

    public RacingCar() {
        this.random = new RandomGenerator();
    }

    public RacingCar(Random random) {
        this.random = random;
    }

    private boolean canMove() {
        return MIN_RANDOM_NUM_CAN_MOVED <= random.nextInt();
    }

    public void move() {
        if (canMove()) {
            position += MOVE_LENGTH;
        }
    }

    public int getPosition() {
        return position;
    }
}
