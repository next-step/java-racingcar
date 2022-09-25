package racingcar;

public class RacingCar {

    private final int MOVE_LENGTH = 1;
    private int position = 0;

    public void move(MoveCondition moveCondition) {
        if (moveCondition.canMove()) {
            position += MOVE_LENGTH;
        }
    }

    public int getPosition() {
        return position;
    }
}
