package racingcar;

public class Car {

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int move(int value) {
        return CarMoveCondition.isMovable(value) ? move() : stop();
    }

    private int move() {
        return ++distance;
    }

    private int stop() {
        return distance;
    }

    public String toString() {
        return "-".repeat(distance);
    }

}
