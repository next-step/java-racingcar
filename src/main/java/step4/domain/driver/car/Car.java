package step4.domain.driver.car;

import step4.domain.startegy.move.MoveStrategy;

public class Car {

    private final String UNIT = "-";
    private StringBuilder status;

    public static Car getInstance() {
        return new Car();
    }

    public static Car newInstance(Car other) {
        return new Car(other);
    }

    private Car() {
        status = new StringBuilder();
    }

    private Car(Car other) {
        this.status = other.status;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            status.append(UNIT);
        }
    }

    @Override
    public String toString() {
        return status.toString();
    }

}
