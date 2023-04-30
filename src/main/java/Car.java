public class Car {

    private int number;

    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int number) {
        final int MINIMUM = 4;

        if (number >= MINIMUM) {
            position++;
        }

        this.number = number;
    }

    public boolean equalsPosition(int expected) {
        return this.position == expected;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number=" + number +
                ", position=" + position +
                '}';
    }
}