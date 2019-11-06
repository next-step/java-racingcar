package racing;

public class Car {

    private final int MOVE_CONDITION_NUMBER = 4;
    private final int MOVE_NUMBER = 1;
    private final int STOP_NUMBER = 0;

    public final String carName;

    public int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = STOP_NUMBER;
    }

    public int move(int movableValue) {
        return position += isMovable(movableValue);
    }

    private int isMovable(int movableValue) {
        return (movableValue >= MOVE_CONDITION_NUMBER) ? MOVE_NUMBER : STOP_NUMBER;
    }

    public int getWinnerPosition(int winnerPosition) {
        return Math.max(this.position, winnerPosition);
    }

    public boolean isBiggerThanWinnerPosition(int winnerPosition) {
        return this.position > winnerPosition;
    }

    public boolean isEqualWinnerPosition(int winnerPosition) {
        return this.position == winnerPosition;
    }
}
