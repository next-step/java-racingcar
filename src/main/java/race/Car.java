package race;

public class Car {
    private int location = 0;

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        location++;
    }

    public int location() {
        return location;
    }

    public String name() {
        return name;
    }
}
