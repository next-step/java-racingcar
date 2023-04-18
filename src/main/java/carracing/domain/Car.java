package carracing.domain;

public class Car {
    private int location;
    private String name;

    public Car() {
        this.location = 0;
    }

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void move() {
        location++;
    }
}
