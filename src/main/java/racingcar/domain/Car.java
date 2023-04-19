package racingcar.domain;

import java.util.Objects;

public class Car {

    public static final int MOVE_STANDARD = 4;

    private final CarName name;
    private int moveCount;

    public Car(String name, int moveCount) {
        this.name = new CarName(name);
        this.moveCount = moveCount;
    }

    public boolean moveCountIsGreaterThan(int maxMoveCount) {
        return moveCount > maxMoveCount;
    }

    public boolean moveCountIsEqualTo(int maxMoveCount) {
        return moveCount == maxMoveCount;
    }

    public String name() {
        return name.getName();
    }

    public int moveCount() {
        return moveCount;
    }

    public void makeMoveCount(int number) {
        if(isCarMovable(number)) {
            moveCount++;
        }
    }

    private boolean isCarMovable(int number) {
        return number >= MOVE_STANDARD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return moveCount == car.moveCount && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moveCount);
    }
}
