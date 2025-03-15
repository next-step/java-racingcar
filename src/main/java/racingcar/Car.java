package racingcar;

import java.util.Random;

public class Car {

    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MOVE_BOUND = 4;

    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(Random random) {
        if (this.isMove(random)) {
            this.position++;
        }
    }

    private boolean isMove(Random random) {
        return this.getRandomNumber(random) >= Car.MOVE_BOUND;
    }

    private int getRandomNumber(Random random) {
        return random.nextInt(Car.RANDOM_NUMBER_BOUND);
    }
}
