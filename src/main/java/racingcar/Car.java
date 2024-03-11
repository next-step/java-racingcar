package racingcar;

public class Car {

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int move(int value) {
        if (CarMoveCondition.isMovable(value)) {
            return move();
        }
        return stop();
    }

    private int move() {
        return ++distance;
    }

    private int stop() {
        return distance;
    }

    public int getDistance() {
        return this.distance;
    }

}
