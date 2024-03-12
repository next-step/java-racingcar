package racingcar.domain;

public class Car {

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public void move(CarMoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

}
