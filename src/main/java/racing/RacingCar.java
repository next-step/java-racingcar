package racing;

import org.apache.commons.lang3.StringUtils;

import static racing.Consts.PROGRESS_POSITION;

public class RacingCar {
    String name;
    int position;

    public RacingCar() {
    }

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

//    public int move(MovingStrategy movingStrategy) {
//        if(movingStrategy.isMove())
//            return position += 1;
//        return position;
//    }

    public int move2(boolean isMove) {
        if(isMove)
            return position += 1;
        return position;
    }

    public boolean isMoving(int randomValue) {
        return randomValue >= Consts.MOVE_MIN_COUNT;
    }

    public boolean isMaxPosition(int maxPosition) {
        return maxPosition == position;
    }

    public int findMaxPosition(int checkPosition) {
        if (position > checkPosition)
            return position;
        return checkPosition;
    }

    @Override
    public String toString() {
        return StringUtils.repeat(PROGRESS_POSITION, position);
    }

    public String getName() {
        return name;
    }
}
