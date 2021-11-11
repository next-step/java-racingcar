package race;

public class Car {
    private int location = 0;

    private final CarName name;

    public Car(CarName name) {
        this.name = name;
    }

    public void move() {
        location++;
    }

    public int location() {
        return location;
    }

    public CarName name() {
        return name;
    }
}
