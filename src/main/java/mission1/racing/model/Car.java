package mission1.racing.model;

public class Car {
    public String name;
    public int carPositions;

    public Car() {}
    public Car(String name) {
        this.name = name;
    }

    public void go() {
        carPositions++;
    }
}
