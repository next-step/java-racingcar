package study.step3.domain;

public class Car {

    private static final int START_POSITION = 0;
    private static final int MOVE_FORWARD_BASIS = 4;
    private int position;

    public Car() {
        this.position = START_POSITION;
    }

    public void moveForwardIfNumberValid(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_BASIS) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
