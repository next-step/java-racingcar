package racingcar;

public class Car {

    public static final String DISTANCE_SYMBOL = "-";
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
        return DISTANCE_SYMBOL.repeat(drivingDistance);
    }
}
