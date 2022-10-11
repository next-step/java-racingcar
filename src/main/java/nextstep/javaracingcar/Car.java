package nextstep.javaracingcar;

public class Car {
    private final String name;
    private Distance distance;
    private final MovingStrategy movingStrategy;

    public Car(final String name, final MovingStrategy movingStrategy) {
        this.name = name;
        this.distance = Distance.ZERO;
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        this.distance = this.distance.plus(movingStrategy.move());
    }

    public CarDrivingResult drivingResult() {
        return new CarDrivingResult(name, distance);
    }
}
