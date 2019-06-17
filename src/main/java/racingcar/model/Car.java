package racingcar.model;

public class Car {
    private DrivingRule drivingRule;
    private String name;
    private int position = 0;

    private Car(DrivingRule drivingRule, String name) {
        this.drivingRule = drivingRule;
        this.name = name;
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

    public int move() {
        if (!drivingRule.isMovable()) {
            return position;
        }
        return ++position;
    }

    @Override
    public String toString() {
        return name;
    }
}
