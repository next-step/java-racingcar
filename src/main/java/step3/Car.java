package step3;

public class Car {
    private static final int DEFAULT_POSITION = 0;

    private int position = DEFAULT_POSITION;
    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
