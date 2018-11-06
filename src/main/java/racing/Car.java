package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final int MOVING_STANDARD_VALUE = 4;
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    public void addPosition(int randomValue) {
        if (randomValue < MOVING_STANDARD_VALUE) {
            return;
        }
        ++position;
    }
}
