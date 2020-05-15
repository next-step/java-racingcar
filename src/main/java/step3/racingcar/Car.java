package step3.racingcar;

public class Car {

    private static final int START_POSITION = 0;

    private int position;

    public Car() {
        this.position = START_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void movePosition() {
        this.position++;
    }
}
