package racing.model;

public class CarModel {
    private int distance = 0;

    public void go() {
        this.distance = ++this.distance;
    }

    public int totalDistance() {
        return this.distance;
    }
}
