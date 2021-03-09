package racingcar;

public class Car {
    private int position = 0;

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
