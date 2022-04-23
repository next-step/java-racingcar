package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public boolean isAhead(int position) {
        return getPosition() > position;
    }

    public boolean isBehind(int position) {
        return getPosition() < position;
    }

    public boolean isAtSamePosition(int position) {
        return getPosition() == position;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && carName.equals(car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
