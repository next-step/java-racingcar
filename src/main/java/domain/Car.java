package domain;

public class Car {

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getCarName() {
        return this.name;
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
