package racingcar;

public class Car {

    private static final String DISTANCE_SYMBOL = "-";
    private static final String RESULT_DIVIDER = " : ";

    private final Name name;
    private final DrivingDistance drivingDistance;

    public Car(String name) {
        this.name = new Name(name);
        this.drivingDistance = new DrivingDistance();
    }

    public Car(String name, int drivingDistance) {
        this.name = new Name(name);
        this.drivingDistance = new DrivingDistance(drivingDistance);
    }

    public void drive(DrivingStrategy drivingStrategy) {
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
