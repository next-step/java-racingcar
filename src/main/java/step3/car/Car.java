package step3.car;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int distance) {
        this.position += distance;
    }

    public int getPosition() {
        return position;
    }
}
