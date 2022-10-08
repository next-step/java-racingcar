package fourstep.logic;


public class Car {

    private static final int THRESHOLD = 4;
    private int location = 1;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void move(int number) {
        if (number >= THRESHOLD) {
            location += 1;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}

