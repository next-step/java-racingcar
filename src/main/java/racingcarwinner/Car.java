package racingcarwinner;

public class Car {

    private String name;
    private int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public static Car createDefaultCar(String name) {
        return new Car(name, 1);
    }

    public void move() {
        this.location += 1;
    }
}
