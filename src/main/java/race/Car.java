package race;

public class Car {
    private int location = 0;

    private final String name;

    public Car(String name) {
        if(name == null || name.trim().isEmpty() || name.trim().length() > 5) {
            throw new IllegalArgumentException("invalid name");
        }
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
