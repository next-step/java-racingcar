package step3;

public class Car {
    private int position;

    Car() {
        position = 1;
    }

    public int move() {
        return position++;
    }

    public int getPosition() {
        return position;
    }
}
