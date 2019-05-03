package racing;

import org.apache.commons.lang3.StringUtils;

public class RacingCar {
    public static final String PROGRESS_POSITION = "-";
    int position;

    public int move(MovingStrategy movingStrategy) {
        if(movingStrategy.isMove())
            return position += 1;
        return position;
    }

    @Override
    public String toString() {
        return StringUtils.repeat(PROGRESS_POSITION, position);
    }
}
