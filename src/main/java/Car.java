public class Car {

    private int number;

    private int position;


    public Car(int number) {
        this.position = 0;
        this.number = number;
    }

    public void move() {
        final int MINIMUM = 4;

        if (number >= MINIMUM) {
            position++;
        }
    }

    public boolean equalsPosition(int expected) {
        return this.position == expected;
    }
}