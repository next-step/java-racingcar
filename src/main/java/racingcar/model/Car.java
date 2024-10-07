package racingcar.model;

public class Car {
    private String name;
    private int movingDistance;

    public Car(String name) {
        this(0);
        this.name = name;
    }

    private Car(int movingDistance) {
        this.movingDistance = movingDistance;
    }

    public void move(boolean isCarMovingForward) {
        if(isCarMovingForward) {
            movingDistance++;
        }
    }

    public int getMovingDistance() {
        return this.movingDistance;
    }

    public String getName() {
        return name;
    }
}
