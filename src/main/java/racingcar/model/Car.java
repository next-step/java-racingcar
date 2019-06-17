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
        if (!drivingRule.isMovable()) {
            return carInformation.getPosition();
        }
        return carInformation.increasePosition();
    }

    @Override
    public String toString() {
        return carInformation.getName();
    }
}
