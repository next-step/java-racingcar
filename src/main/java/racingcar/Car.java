package racingcar;

public class Car {

    public static final int MOVE_LIMIT = 4;
    private int distance = 1;

    public void move() {
        this.distance += 1;
    }

    public int getDistance() {
        return distance;
    }

    public boolean moveable(int value) {
        return value >= MOVE_LIMIT;
    }
}
