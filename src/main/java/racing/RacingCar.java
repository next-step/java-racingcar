package racing;

import org.apache.commons.lang3.StringUtils;

public class RacingCar {
    public static final int MOVE_MIN_COUNT = 4;
    public static final String PROGRESS_POSITION = "-";
    int position;

    public int move(int randomValue) {
        if (isMoving(randomValue))
            return position += 1;
        return position;
    }

    public int move2(MovingStrategy movingStrategy) {
        if(movingStrategy.isMove()){
            return position += 1;
        }
        return position;
    }

    private boolean isMoving(int randomValue) {
        return randomValue >= MOVE_MIN_COUNT;
    }

    @Override
    public String toString() {
        return StringUtils.repeat(PROGRESS_POSITION, position);
    }
}
