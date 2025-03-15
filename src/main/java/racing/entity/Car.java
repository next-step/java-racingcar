package racing.entity;

public class Car {
    private int position = 1;

    public Car() {
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}
