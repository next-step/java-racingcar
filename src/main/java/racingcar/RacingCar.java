package racingcar;

public class RacingCar {
    private static final int NUMBER_MOVING_STANDARD = 4;
    private static final String PROGRESS_POSITION = "-";
    private int position;

    public int move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            return ++position;
        }
        return position;
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= NUMBER_MOVING_STANDARD;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(PROGRESS_POSITION);
        }
        return builder.toString();
    }
}
