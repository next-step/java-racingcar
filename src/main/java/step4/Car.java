package step4;

public class Car {
    private static final int STARTING_POINT = 0;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = STARTING_POINT;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void go() {
        this.position++;
    }

}
