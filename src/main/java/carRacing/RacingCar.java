package carRacing;

public class RacingCar {

    public static final int MOVE_CONDITION = 4;
    private int position;

    public int getPosition() {
        return position;GIT
    }

    private void movePosition() {
        position++;
    }

    public void move(int value) {
        if (value >= MOVE_CONDITION) {
            movePosition();
        }
    }

}
