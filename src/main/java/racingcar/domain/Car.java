package racingcar.domain;

public class Car {

    private final Name name;
    private final Distance distance;

    public Car(Name name) {
        this.name = name;
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

    public Name getName() { return this.name; }

}
