package racing.model;

public class Car {
    private String carName = "";
    private int distance = 0;

    public void go() {
        this.distance = ++this.distance;
    }

    public void setCarName(String name) {
        this.carName = name;
    }

    public int totalDistance() {
        return this.distance;
    }
}
