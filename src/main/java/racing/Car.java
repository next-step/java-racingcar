package racing;

public class Car {
    private static final int MOVING_STANDARD = 3;
    private static final int GO = 1;
    private final MovingCondition movingCondition;

    private int position;

    public Car(MovingCondition condition) {
        movingCondition = condition;
    }

    public void move() {
        position = movingCondition.getCondition() > MOVING_STANDARD ? position + GO : position;
    }

    public int getPosition() {
        return position;
    }
}
