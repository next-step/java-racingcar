package step3.domain;

public class Car {

    private static final int CAN_MOVE_NUMBER = 4;

    private int position;

    public Car() {
        this.position = 1;
    }

    public void moveCheck(int random) {
        if (random > CAN_MOVE_NUMBER) {
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
