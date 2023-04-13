package CarRacing;

public class Car {
    private static final int INITIAL_POSITION=1;

    private int position;

    public Car() {
        this.position = INITIAL_POSITION;
    }

    public void move(int number) {
        this.position += number;
    }

    public int current() {
        return this.position;
    }

}
