package racingcar;

public class Car {
    public final static int INITIAL_POSITION = 1;
    private int position = INITIAL_POSITION;

    public void moveOrStay(int value) {
        if (MovingForwardCondition.isSatisfied(value)) {
            move();
        }
    }

    private void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
