package racing.application;

public class Car {
    private int position = 1;

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
