package racingCar.step3;

public class Car {

    private static final int MINIMUM_MOVE_THRESHOLD = 4;

    private int position;

    public void move(int moveCondition){
        if(isMoveable(moveCondition)) this.position++;
    }

    private boolean isMoveable(int moveCondition) {
        return moveCondition >= MINIMUM_MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }
}
