package racingcar.domain;

public class Car {

    private final Name name;
    private final Distance distance;

    // Constructor for UnitTest
    public Car() {
        this.name = new Name();
        this.distance = new Distance();
    }

    public Car(Name name) {
        this.name = name;
        this.distance = new Distance();
    }

    // Constructor for UnitTest
    public Car(Distance distance, Name name) {
        this.name = name;
        this.distance = distance;
    }

    public Car(Car car) {
        this.name = new Name(car.getName().get());
        this.distance = new Distance(car.getDistance().get());
    }

    public void move(CarMoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            distance.increase();
        }
    }

    public Distance getDistance() {
        return this.distance;
    }

    public Name getName() {
        return this.name;
    }

}
