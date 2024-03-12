package racingcar.domain;

public class Car {

    private final Distance distance;

    public Car() {
        this.distance = new Distance();
    }

    public void move(CarMoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            distance.increase();
        }
    }

    public Distance getDistance() {
        return this.distance;
    }

}
