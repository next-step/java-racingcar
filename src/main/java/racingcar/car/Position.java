package racingcar.car;

public class Position {
    private int position;

    public static final int defaultDistance = 0;
    public static final int forwardDistance = 1;

    public Position() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public boolean canMove(int number) {
        return number >= 4;
    }

    public void moveForward() {
        this.position += forwardDistance;
    }
}
