package racingcar.model;

public class Car {
    private DrivingRule drivingRule;
    private int position = 0;

    private Car(DrivingRule drivingRule) {
        this.drivingRule = drivingRule;
    }

    public static Car createCar() {
        return new Car(RandomDrivingRule.getInstance());
    }

    public static Car createCarWithDrivingRule(DrivingRule drivingRule) {
        if (drivingRule == null) {
            return createCar();
        }
        return new Car(drivingRule);
    }

    public int move() {
        if (!drivingRule.isMovable()) {
            return position;
        }
        return ++position;
    }
}
