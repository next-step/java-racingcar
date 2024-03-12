package racingcar.domain;

import racingcar.domain.dto.DriveResult;

public class Car {

    private static final String DISTANCE_SYMBOL = "-";
    private static final String RESULT_DIVIDER = " : ";

    private final Name name;
    private DrivingDistance drivingDistance;

    public Car(String name) {
        this(Name.of(name), new DrivingDistance());
    }

    public Car(String name, int drivingDistance) {
        this(Name.of(name), DrivingDistance.of(drivingDistance));
    }

    public Car(Name name, DrivingDistance drivingDistance) {
        this.name = name;
        this.drivingDistance = drivingDistance;
    }

    public void drive(DrivingStrategy drivingStrategy) {
        if (drivingStrategy.canDrive()) {
            this.drivingDistance = drivingDistance.moveForward();
        }
    }

    public boolean matchDistance(int distance) {
        return drivingDistance.matchDistance(distance);
    }

    public DriveResult driveResult() {
        return new DriveResult(name, drivingDistance);
    }

    public int drivingDistance() {
        return drivingDistance.value();
    }

    public String name() {
        return name.value();
    }
}
