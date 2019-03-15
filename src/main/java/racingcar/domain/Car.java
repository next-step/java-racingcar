package racingcar.domain;

public class Car {
    public static final int MOVE_THRESHOLD = 3;
    private static final int INITIAL_MOVED_DISTANCE = 0;

    private String name;
    private int movedDistance;

    public Car(String name) {
        this(name, INITIAL_MOVED_DISTANCE);
    }

    Car(String name, int movedDistance) {
        this.name = name;
        this.movedDistance = movedDistance;
    }

    void go() {
        this.movedDistance++;
    }

    public boolean goWhenGreaterThanThreshold(int value) {
        if (MOVE_THRESHOLD < value) {
            go();
            return true;
        }

        return false;
    }

    public String getName() {
        return this.name;
    }

    public int getMovedDistance() {
        return this.movedDistance;
    }

    public Car copy() {
        return new Car(this.name, this.movedDistance);
    }

    public void initialize() {
        this.movedDistance = INITIAL_MOVED_DISTANCE;
    }
}
