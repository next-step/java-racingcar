package racingcar.domain;

public class Car {
    public static final int MOVE_THRESHOLD = 3;

    private String name;
    private int movedDistance = 0;

    public Car(String name) {
        this.name = name;
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
}
