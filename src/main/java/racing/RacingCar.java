package racing;

import org.apache.commons.lang3.StringUtils;

import static racing.Consts.PROGRESS_POSITION;

public class RacingCar {
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
