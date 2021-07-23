package study.step3;

import java.util.Random;

public class Driver {

    private static final int BOUND = 10;
    private static final int MOVE_FORWARD_BASIS = 4;
    private final Car car;

    public Driver(Car car) {
        this.car = car;
    }

    public void drive() {
        if (canDriverMoveForward()) {
            car.moveForward();
        }
    }

    private boolean canDriverMoveForward() {
        return new Random().nextInt(BOUND) >= MOVE_FORWARD_BASIS;
    }
}
