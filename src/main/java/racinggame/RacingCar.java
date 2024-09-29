package racinggame;

public class RacingCar {
    public static final int MOVE_THRESHOLD = 4;
    private int position;

    public RacingCar() {
        this.position = 0;
    }

    public boolean move(final int moveCondition) {
        if (moveCondition > MOVE_THRESHOLD) {
            this.position++;
            return true;
        }

        return false;
    }

    public int currentPosition() {
        return this.position;
    }
}
