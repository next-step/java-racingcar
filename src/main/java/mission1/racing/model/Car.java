package mission1.racing.model;

public class Car {
    private String name;
    private int carPositions;

    public Car() {}
    public Car(String name) {
        this.name = name;
    }

    public void go() {
        carPositions++;
    }

    public int getCarPositions() {
        return carPositions;
    }

    public String getName() {
        return name;
    }
}
