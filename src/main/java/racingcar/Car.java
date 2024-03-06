package racingcar;

public class Car {

    private final DrivingStrategy drivingStrategy;
    private int drivingDistance = 0;

    public Car(DrivingStrategy drivingStrategy) {
        this.drivingStrategy = drivingStrategy;
    }

    public void drive() {
        if (drivingStrategy.canDrive()) {
            drivingDistance++;
        }
    }

    public int drivingDistance() {
        return drivingDistance;
    }

    public String getResult() {
        return "-".repeat(drivingDistance);
    }
}
