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

    public boolean sameLocation(int location) {
        return this.location == location;
    }

    public CarName name() {
        return name;
    }
}
