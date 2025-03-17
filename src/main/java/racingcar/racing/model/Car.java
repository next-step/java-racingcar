package racingcar.racing.model;

public class Car {
    private int position;

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }
}
