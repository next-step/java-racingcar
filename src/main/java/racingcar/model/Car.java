package racingcar.model;

public class Car {
    private DrivingRule drivingRule;
    private int position = 0;

    private Car(DrivingRule drivingRule) {
        this.drivingRule = drivingRule;
    }

    public static Car create() {
        return new Car(RacingDrivingRule.createDefault());
    }

    public static Car createWithDrivingRule(DrivingRule drivingRule) {
        if (drivingRule == null) {
            return create();
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
