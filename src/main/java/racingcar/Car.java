package racingcar;

public class Car {

    private static final String DISTANCE_SYMBOL = "-";

    private final DrivingStrategy drivingStrategy;
    private final Name name;
    private int drivingDistance = 0;

    public Car(DrivingStrategy drivingStrategy, String name) {
        this.drivingStrategy = drivingStrategy;
        this.name = new Name(name);
    }

    public Car(DrivingStrategy drivingStrategy) {
        this(drivingStrategy, "temp");
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
        return name + " : " + DISTANCE_SYMBOL.repeat(drivingDistance);
    }

    public boolean matchDistance(int distance) {
        return drivingDistance == distance;
    }

    public String name() {
        return name.name();
    }
}
