package step3;

import java.util.Random;

public class Car {
    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    public void moveCar() {
        this.distance++;
    }

    public void validateForMove(Random random) {
        if (random.nextInt(10) >= 4) {
            this.moveCar();
        }
    }
}
