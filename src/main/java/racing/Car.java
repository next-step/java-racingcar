package racing;

public class Car {
    private static final int MOVING_CONDITION_COUNT = 3;
    private static final int MOVING_DISTANCE = 1;
    private final MovingCondition movingCondition;

    private int position;

    public Car(MovingCondition condition) {
        movingCondition = condition;
    }

    public void move() {
        position = movingCondition.getCondition() > MOVING_CONDITION_COUNT ? position + MOVING_DISTANCE : position;
    }

    public int getPosition() {
        return position;
    }
}
