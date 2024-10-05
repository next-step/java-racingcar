package racingcar.model;

public class Car {
    private int movingDistance;

    public Car() {
        this(0);
    }

    private Car(int movingDistance) {
        this.movingDistance = movingDistance;
    }

    public void move(boolean isCarMovingForward) {
        if(isCarMovingForward)
            movingDistance++;
    }

    public int getMovingDistance() {
        return this.movingDistance;
    }
}
