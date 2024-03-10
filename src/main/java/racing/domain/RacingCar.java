package racing.domain;

public class RacingCar {
    private int position;

    private static final int MOVE_BORDER_NUMBER = 4;

    public RacingCar() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void attemptToMove(int conditionNumber) {
        if (conditionNumber >= MOVE_BORDER_NUMBER) {
            move();
        }
    }

    private void move() {
        this.position++;
    }
}
