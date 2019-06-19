package racingcar.model;

import java.util.Objects;

public class CarInformation {
    private final CarName name;
    private final Position position;
    private final DrivingRule drivingRule;

    private CarInformation(CarName name, Position position, DrivingRule drivingRule) {
        this.name = name;
        this.position = position;
        this.drivingRule = drivingRule;
    }

    public static CarInformation create(CarName name) {
        DrivingRule drivingRule = RacingDrivingRule.createDefault();
        return createWithRule(name, drivingRule);
    }

    public static CarInformation createWithRule(CarName name, DrivingRule drivingRule) {
        Position position = Position.valueOf(0);
        return new CarInformation(name, position, drivingRule);
    }

    public static CarInformation createWithPosition(CarName name, Position position) {
        DrivingRule drivingRule = RacingDrivingRule.createDefault();
        return new CarInformation(name, position, drivingRule);
    }

    public static CarInformation createWithPositionAndRule(CarName name, Position position, DrivingRule drivingRule) {
        return new CarInformation(name, position, drivingRule);
    }

    public CarName getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public DrivingRule getDrivingRule() {
        return drivingRule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarInformation)) return false;
        CarInformation that = (CarInformation) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
