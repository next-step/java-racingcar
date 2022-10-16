package racing.domain;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int moveNumber) {
        position += moveNumber;
    }

    public int getPosition() {
        return position;
    }
}
