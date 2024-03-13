package racing.domain;

public class RacingCar {
    private static final int MOVE_BORDER_NUMBER = 4;

    private int position;

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
