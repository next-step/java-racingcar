package racing.model;

public class CarModel {
    private int distance;

    public CarModel() {
        this.distance = 0;
    }

    public void go() {
        this.distance = this.distance+1;
    }

    public int totalDistance() {
        return this.distance;
    }
}
