package racingcar.domain;

public class Car {
    private static final int MOVE_STANDARD = 4;
    private static final int MOVE_DISTANCE = 1;

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() { return this.name; }

    public void move(int movableNumber) {
        if (movableNumber >= MOVE_STANDARD) {
            distance += MOVE_DISTANCE;
        }
    }

    public boolean matchDistance(int distance) {
        return this.distance == distance;
    }
}
