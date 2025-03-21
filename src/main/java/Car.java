public class Car {
    private static final int STANDARD_VALUE = 4;
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public Car() {
        this(0);
    }

    public void moveOneBy(int value) {
        if (value > STANDARD_VALUE) {
            this.position++;
        }
    }

    public boolean isPosition(int value) {
        return this.position == value;
    }

    public int getPosition() {
        return this.position;
    }
}
