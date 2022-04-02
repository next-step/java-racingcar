package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int BASE_MOVE_VALUE = 4;
    public static final int MAX_MOVE_VALUE = 10;
    private final String carName;
    private int position;
    private List<Integer> positionHistory;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
        this.positionHistory = new ArrayList<>();
    }

    public boolean isValid() {
        return carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    public void move(int moveValue) {
        if (moveValue >= BASE_MOVE_VALUE) {
            position++;
        }
        positionHistory.add(position);
    }

    public int comparePosition(int targetPosition) {
        return Integer.compare(position, targetPosition);
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public List<Integer> getPositionHistory() {
        return Collections.unmodifiableList(positionHistory);
    }
}
