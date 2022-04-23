package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int BASE_MOVE_VALUE = 4;
    public static final int MAX_MOVE_VALUE = 10;
    private final CarName carName;
    private int position;
    private List<Integer> positionHistory;

    private Car(CarName carName, int position, List<Integer> positionHistory) {
        this.carName = carName;
        this.position = position;
        this.positionHistory = positionHistory;
    }

    public static Car create(CarName carName) {
        return new Car(carName, 0, new ArrayList<>());
    }

    public Car move(int moveValue) {
        List<Integer> movedPositionHistory = new ArrayList<>(positionHistory);
        int movedPosition = position;
        if (moveValue >= BASE_MOVE_VALUE) {
            movedPosition++;
        }
        movedPositionHistory.add(movedPosition);
        return new Car(carName, movedPosition, movedPositionHistory);
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public List<Integer> getPositionHistory() {
        return Collections.unmodifiableList(positionHistory);
    }
}
