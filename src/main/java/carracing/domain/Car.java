package carracing.domain;

import java.util.Objects;

public class Car {
    private static final int CAN_MOVE_THRESHOLD = 4;
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move(int value) {
        if (value > CAN_MOVE_THRESHOLD) {
            this.position += 1;
        }
    }
}
