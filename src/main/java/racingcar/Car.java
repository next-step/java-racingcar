package racingcar;

import java.util.Random;

public class Car {
    private String carName;
    private int position;
    private static final Random random = new Random(54321);

    public Car(String carName) {
        this.carName = carName;
        position = 0;
    }

    public String carName() {
        return this.carName;
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
