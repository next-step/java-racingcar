package racingcar.domain;

public class Car {
    private int position = 0;

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
