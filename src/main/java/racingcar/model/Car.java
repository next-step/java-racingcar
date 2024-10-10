package racingcar.model;

public class Car {
    private String name;
    private int movingDistance;

    public Car(String name) {
        this(name, 0);
    }

    private Car(String name, int movingDistance) {
        this.name = name;
        this.movingDistance = movingDistance;
    }

    public void move(boolean isCarMovingForward) {
        if (isCarMovingForward) {
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
