package step3;

public class Car {

    private static final int MIN_MOVING_CONDITION = 4;
    private static final int POSITION_MOVE = 1;

    private int currentPosition = 0;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move(int randomValue) {
        if(checkMovable(randomValue)) {
            this.currentPosition += POSITION_MOVE;
        }
    }

    private boolean checkMovable(int randomValue) {
        return randomValue >= MIN_MOVING_CONDITION;
    }

}
