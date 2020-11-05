package racingcar.model;

public class Car {

    private static final int INITIAL_POSITION = 0;

    int position;

    public Car() {
        this.position = INITIAL_POSITION;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }
}
