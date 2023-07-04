package car;

public class Car {

    private int position;
    private String name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void moveOrStopByValue(int value) {
        if (value >= 4) {
            position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
