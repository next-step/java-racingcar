package racingcar.model;

import java.util.Objects;

public class Car {
    private CarInformation carInformation;

    private Car(CarInformation carInformation) {
        this.carInformation = carInformation;
    }

    public static Car create(String name) {
        CarInformation carInformation = CarInformation.create(name);
        return new Car(carInformation);
    }

    public static Car createWithDrivingRule(String name, DrivingRule drivingRule) {
        if (drivingRule == null) {
            return create(name);
        }
        CarInformation carInformation = CarInformation.createWithRule(name, drivingRule);
        return new Car(carInformation);
    }

    public Position move() {
        DrivingRule drivingRule = carInformation.getDrivingRule();
        Position position = carInformation.getPosition();

        if (drivingRule.isMovable()) {
            Position step = Position.valueOf(1);
            position = Position.add(position, step);

            String name = carInformation.getName();
            carInformation = CarInformation.createWithPositionAndRule(name, position, drivingRule);
        }

        return position;
    }

    public CarInformation getInformation() {
        String name = carInformation.getName();
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
