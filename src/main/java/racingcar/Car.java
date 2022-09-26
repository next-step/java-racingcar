package racingcar;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void forwardCarByCondition(int value) {
        if (ForwardCondition.isForwardCondition(value)) {
            moveForward();
        }
    }

    private void moveForward() {
        this.position++;
    }

}
