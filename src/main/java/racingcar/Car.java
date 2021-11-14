package racingcar;

import java.util.Random;

public class Car {

    private final int location;
    private final Random random = new Random();

    public Car(int location) {
        this.location = location;
    }

    public Car move() {
        return new Car(this.location + randomMove());
    }

    private int randomMove() {
        if (random.nextInt(10) > 4) {
            return 1;
        }
        return 0;
    }

    public int getLocation() {
        return location;
    }
}
