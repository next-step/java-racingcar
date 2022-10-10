package racing.core;

public class Car {

    private int distance = 1;

    public Car() {
    }

    public int getDistance() {
        return this.distance;
    }

    public void stepAhead(int stepCount) {
        this.distance += stepCount;
    }
}
