package racingcar.domain;

public class Car {

    private final Name name;
    private final Distance distance;

    // Primary Constructor, 주생성자
    public Car(int distance, String name) {
        this.distance = new Distance(distance);
        this.name = new Name(name);
    }

    public Car(String name) {
        this(0, name);
    }

    public Car(Car car) {
        this(car.distance.get(), car.name.get());
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
