package core;

import java.util.*;

public class Car {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int BASE_MOVE_VALUE = 4;
    public static final int MAX_MOVE_VALUE = 10;
    private final String id;
    private final CarName carName;
    private int position;

    private Car(String id, CarName carName, int position) {
        this.id = id;
        this.carName = carName;
        this.position = position;
    }

    public static Car create(CarName carName) {
        return new Car(UUID.randomUUID().toString(), carName, 0);
    }

    public Car move(int moveValue) {
        int movedPosition = position;
        if (moveValue >= BASE_MOVE_VALUE) {
            movedPosition++;
        }
        return new Car(id, carName, movedPosition);
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

    public boolean isSameId(String comparedId) {
        return id.equals(comparedId);
    }

    public String getId() {
        return id;
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && id.equals(car.id) && carName.equals(car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carName, position);
    }
}
