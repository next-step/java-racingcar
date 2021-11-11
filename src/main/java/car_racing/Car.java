package car_racing;

import java.util.Objects;

public class Car {

    private static final MoveStrategy moveStrategy = new RandomMoveStrategy();

    private final int id;
    private Status currStatus;

    public Car(int carId) {
        currStatus = Status.STOP;
        id = carId;
    }

    /** test **/
    public Car(int carId, Status status) {
        currStatus = status;
        id = carId;
    }

    public void move() {
        if (ableToMove()) {
            currStatus = Status.MOVE;
        }
    }

    public Status getCurrStatus() {
        return currStatus;
    }

    public int getId() {
        return id;
    }

    private boolean ableToMove() {
        return moveStrategy.decideToMove();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && currStatus == car.currStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currStatus);
    }
}
