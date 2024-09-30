package step3.car;

public class Car {
    private static final int DEFAULT_POSITION = 0;

    private int position;

    public Car() {
        this.position = DEFAULT_POSITION;
    }

    public void move() {
        this.position += 1;
    }

    public int getPosition() {
        return position;
    }
}
