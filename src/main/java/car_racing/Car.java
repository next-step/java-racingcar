package car_racing;

import java.util.Random;

public class Car {

    private static final Integer START_POSITION = 1;

    private Integer position;

    public Car() {
        this.position = START_POSITION;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void move() {
        int point = RandomPoint.getPoint();
        if (movable(point)) {
            position += point;
        }
    }

    private boolean movable(int i) {
        return i >= 4;
    }
}
