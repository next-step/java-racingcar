package CarRacing;

public class Car {
    private static final int INITIAL_POSITION=1;

    private int position;
    private String name;

    public Car(String name) {
        this.position = INITIAL_POSITION;
        this.name = name;
    }

    public void move(int number) {
        this.position += number;
    }

    public int current() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
