package racingcar.domain;

public class Car {

    private final Name name;
    private final Distance distance;

    public Car(Name name) {
        this.name = name;
        this.distance = new Distance();
    }

    // Constructor for UnitTest
    public Car(int distance, String name) {
        this.distance = new Distance(distance);
        this.name = new Name(name);
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
