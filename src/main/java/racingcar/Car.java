package racingcar;

public class Car {

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public void move(int value) {
        if (CarMoveCondition.isMovable(value)) {
            move();
        }
    }

    private void move() {
        this.distance++;
    }

    public int getDistance() {
        return this.distance;
    }

}
