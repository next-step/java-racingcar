package step3.model;

public class Car {
    private int distance;

    public Car() {
        this.distance = 1;
    }

    public int showDistance() {
        return distance;
    }

    public void increseDistance() {
        this.distance++;
    }
}
