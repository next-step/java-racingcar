package racing.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Car {
    private static final AtomicInteger CAR_NO_INTEGER = new AtomicInteger(0);

    private final int MOVE_THRESHOLD = 4;
    private final int carNo;
    private int position;

    public Car() {
        this.carNo = CAR_NO_INTEGER.getAndIncrement();
        this.position = 0;
    }

    public int getCarNo() {
        return carNo;
    }

    public int getPosition() {
        return position;
    }

    public void move(int input) {
        if (validateInput(input)) {
            this.position++;
        }

    }

    public boolean validateInput(int input) {
        return input >= MOVE_THRESHOLD;
    }
}
