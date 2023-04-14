package racingcar.model;

public class Distance {
    private static final int DEFAULT_DISTANCE = 0;
    private int distance;

    public Distance() {
        this.distance = DEFAULT_DISTANCE;
    }

    public Distance(int distance) {
        this.distance = distance;
    }

    public void move(int amount) {
        this.distance += amount;
    }

    public int value() {
        return this.distance;
    }

    public boolean isSame(int distance) {
        return this.distance == distance;
    }
}
