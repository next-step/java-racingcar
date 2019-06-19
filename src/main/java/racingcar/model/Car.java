package racingcar.model;

import java.util.Objects;

public class Car {
    private static final int ONE_STEP_DISTANCE = 1;
    private CarInformation carInformation;

    private Car(CarInformation carInformation) {
        this.carInformation = carInformation;
    }

    public static Car create(CarName name) {
        CarInformation carInformation = CarInformation.create(name);
        return new Car(carInformation);
    }

    public static Car createWithDrivingRule(CarName name, DrivingRule drivingRule) {
        if (drivingRule == null) {
            return create(name);
        }
        CarInformation carInformation = CarInformation.createWithRule(name, drivingRule);
        return new Car(carInformation);
    }

    public Position move() {
        DrivingRule drivingRule = carInformation.getDrivingRule();
        Position position = carInformation.getPosition();

        if (!drivingRule.isMovable()) {
            return position;
        }

        Position step = Position.valueOf(ONE_STEP_DISTANCE);
        position = Position.add(position, step);

        CarName name = carInformation.getName();
        carInformation = CarInformation.createWithPositionAndRule(name, position, drivingRule);
        return position;
    }

    public CarInformation getInformation() {
        CarName name = carInformation.getName();
        Position position = carInformation.getPosition();
        return CarInformation.createWithPosition(name, position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return carInformation.equals(car.carInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carInformation);
    }
}
