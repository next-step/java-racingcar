package carracing;

public class Car {

    public static final int MIN_FORWARD_MOVEMENT = 4;
    private static final int DEFAULT_POSITION = 0;
    private int position;

    public Car() {
        this(DEFAULT_POSITION);
    }

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move(int value) {
        if (value >= MIN_FORWARD_MOVEMENT) {
            position++;
        }
    }
}
