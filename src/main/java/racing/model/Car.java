package racing.model;

public class Car {
    private String carName = "";
    private int distance = 0;

    public Car(String name) {
        checkCarName(name);
        this.carName = name;
    }

    public void go() {
        this.distance = ++this.distance;
    }

    public int totalDistance() {
        return this.distance;
    }

    public void checkCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getCarInfo() {
        return this.carName;
    }
}
