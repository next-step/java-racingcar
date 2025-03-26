package racingcar.domain;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position += 1;
    }
}
