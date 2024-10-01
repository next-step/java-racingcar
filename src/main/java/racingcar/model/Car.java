package racingcar.model;

public class Car {
    private int position;

    public void move() {
        position++;
    }

    public int getMoveCount() {
        return position;
    }
}
