package racingcar.model;

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

            carInformation.setPosition(position);
        }
        return carInformation.getPosition();
    }

    public CarInformation getInformation() {
        String name = carInformation.getName();
        Position position = carInformation.getPosition();

        return new CarInformation(name, position);
    }
}
