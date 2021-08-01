package step3;

import java.util.Objects;

public class Car {
    private static final int MOVE_CRITERION = 4;

    private int moveDistance;

    public Car() {
        this.moveDistance = 0;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void moveForward(int number) {
        if (checkProgressPossible(number)) {
            addMoveDistance();
        }
    }

    private boolean checkProgressPossible(int number) {
        return number >= MOVE_CRITERION;
    }

    public void addMoveDistance() {
        this.moveDistance += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return moveDistance == car.moveDistance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveDistance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "moveDistance=" + moveDistance +
                '}';
    }
}
