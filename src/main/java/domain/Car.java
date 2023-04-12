package domain;

public class Car {

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int getCarCurrentDistance() {
        return distance;
    }

    protected void attemptMove(boolean isMoved) {
        if (isMoved) {
            distance++;
        }
    }
}
