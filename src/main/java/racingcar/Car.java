package racingcar;

import java.util.Random;

public class Car {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_VALUE = 10;
    private static final int THRESHOLD = 4;

    private int position;

    public Car() {
        position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void stopOrMove() {
        if (randomNumber() >= THRESHOLD) {
            position++;
        }
    }

    private int randomNumber() {
        return RANDOM.nextInt(RANDOM_VALUE);
    }
}
