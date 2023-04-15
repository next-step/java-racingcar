package step3.model;

public class Car {
    private int distance;

    public Car(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void increaseDistance() {
        distance++;
    }
}
