package racingcar.domain;

public class Car {
    public static final int MOVE_NUMBER = 4;
    private int position;

    public void move(int number) {
        if (number >= MOVE_NUMBER) {
            position++;
        }
    }

    public int position() {
        return this.position;
    }
}
