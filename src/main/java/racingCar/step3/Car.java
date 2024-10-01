package racingCar.step3;

public class Car {

    private static final int MINIMUM_MOVE_THRESHOLD = 4;

    private int moveCondition;
    private int position;

    public void move(){
        if(isMoveable()) this.position++;
    }

    public void applyMoveCondition(int moveCondition) {
        this.moveCondition = moveCondition;
    }

    private boolean isMoveable() {
        return moveCondition >= MINIMUM_MOVE_THRESHOLD;
    }

    public int getMoveCondition() {
        return moveCondition;
    }

    public int getPosition() {
        return position;
    }
}
