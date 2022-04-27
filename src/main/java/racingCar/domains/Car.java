package racingCar.domains;

import java.util.Random;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move() {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
