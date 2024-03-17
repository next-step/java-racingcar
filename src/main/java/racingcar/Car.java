package racingcar;

import java.util.Random;

public class Car {
    private int position;
    private static final Random random = new Random(54321);

    public Car() {
        position = 0;
    }

    public int position() {
        return this.position;
    }

    public void updatePosition() {
        int randomValue = random.nextInt(10);
        if (randomValue >= 4) {
            position++;
        }
    }
}
