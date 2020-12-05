package racing;

public class Car {
    private static final int MOVING_STANDARD = 3;
    private static final int GO = 1;

    private int position;

    public void move(int movingCondition) {
        position = movingCondition > MOVING_STANDARD ? position + GO : position;
    }

    public int getPosition() {
        return position;
    }
}
