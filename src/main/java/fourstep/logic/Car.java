package fourstep.logic;


public class Car {

    private static final int THRESHOLD = 4;
    private int Location = 1;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= THRESHOLD) {
            Location += 1;
        }
    }

    public int getLocation() {
        return Location;
    }

    public String getName() {
        return name;
    }
}

