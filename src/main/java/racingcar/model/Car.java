package racingcar.model;

import java.util.Objects;

public class Car {
    private DrivingRule drivingRule;
    private CarInformation carInformation;

    private Car(DrivingRule drivingRule, String name) {
        this.drivingRule = drivingRule;
        this.carInformation = new CarInformation(name);
    }

    public static Car create(String name) {
        return new Car(RacingDrivingRule.createDefault(), name);
    }

    public static Car createWithDrivingRule(DrivingRule drivingRule, String name) {
        if (drivingRule == null) {
            return create(name);
        }
        return new Car(drivingRule, name);
    }

    public Position move() {
        if (drivingRule.isMovable()) {
            Position position = carInformation.getPosition();
            position = Position.add(position, Position.valueOf(1));

            carInformation = new CarInformation(carInformation.getName(), position);
        }
        return carInformation.getPosition();
    }

    public CarInformation getInformation() {
        String name = carInformation.getName();
        Position position = carInformation.getPosition();

        return new CarInformation(name, position);
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
