package carracing;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private int position;

    public Car() {
        this(DEFAULT_POSITION);
    }

    public Car(int position) {
        this.position = position;
    }

    public String getPositionRepeat() {
        return "-".repeat(position);
    }

    public int getPosition() {
        return position;
    }

    public void move(int value) {
        if (value >= 4) {
            position++;
        }
    }
}
