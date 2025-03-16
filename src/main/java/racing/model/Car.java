package racing.model;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
