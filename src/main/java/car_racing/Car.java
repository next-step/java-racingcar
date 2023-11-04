package car_racing;

import java.util.Random;

public class Car {

    private static final Integer START_POSITION = 0;

    private Integer position;

    public Car() {
        this.position = START_POSITION;
    }

    public void move() {
        int i = new Random().nextInt(10);
        if (i >= 4) {
            position += i;
        }
    }

    public Integer getPosition() {
        return this.position;
    }
}
