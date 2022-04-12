package racing.module;

public class Car {
    private int position = 0;
    private static final int DEFAULT_POSITION = 0;
    private static final int BOUNDARY_NUMBER = 4;

    public Car() {
        this(DEFAULT_POSITION);
    }

    public Car(int position) {
        this.position = position;
    }

    public void move(int speed) {
        if (speed >= BOUNDARY_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
