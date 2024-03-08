package racingcar;

public class Car {

    private static final String DISTANCE_SYMBOL = "-";
    private static final String RESULT_DIVIDER = " : ";

    private final DrivingStrategy drivingStrategy;
    private final Name name;
    private final DrivingDistance drivingDistance;

    public Car(DrivingStrategy drivingStrategy, String name) {
        this.drivingStrategy = drivingStrategy;
        this.drivingDistance = new DrivingDistance();
        this.name = new Name(name);
    }

    public void drive() {
        if (drivingStrategy.canDrive()) {
            drivingDistance.moveForward();
        }
    }

    public int drivingDistance() {
        return drivingDistance.getDrivingDistance();
    }

    public String getResult() {
        return name + RESULT_DIVIDER + DISTANCE_SYMBOL.repeat(drivingDistance.getDrivingDistance());
    }

    public boolean matchDistance(int distance) {
        return drivingDistance.matchDistance(distance);
    }

    public String name() {
        return name.name();
    }
}
