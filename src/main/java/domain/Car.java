package domain;

public class Car {

    private String name;
    private int distance;

    public Car() {
        this.distance = 0;
    }

    public String getCarName() {
        return getCarName();
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
