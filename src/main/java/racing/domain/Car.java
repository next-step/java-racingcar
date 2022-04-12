package racing.domain;

public class Car {
    private static final int STOP = 0;
    private static final int MOVE_FORWARD = 1;

    private final String name;
    private int distance;

    Car() {
        this.name = "";
        this.distance = 0;
    }

    private Car(int distance) {
        this.name = "";
        this.distance = distance;
    }

    public int accumulateOneRound(Movable movable) {
        distance += moveForwardOrStop(movable);
        return distance;
    }

    public int moveForwardOrStop(Movable movable) {
        if (movable.isMovable()) {
            return MOVE_FORWARD;
        }
        return STOP;
    }

    public int getDistance() {
        return distance;
    }

    public Car newInstance() {
        return new Car(distance);
    }
}
