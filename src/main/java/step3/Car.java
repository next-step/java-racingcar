package step3;

public class Car {
    private int position = 0;

    public int move() {
        return position++;
    }

    public int getPosition() {
        return position;
    }
}
