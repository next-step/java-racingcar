package racingCar;

public class Car {

    private static final int MINIMUM_MOVE_THRESHOLD = 4;

    private final int moveCondition;

    private int position;

    public Car(int moveCondition){
        this.moveCondition = moveCondition;
    }

    public void move(){
        if(isMoveable())this.position++;
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
