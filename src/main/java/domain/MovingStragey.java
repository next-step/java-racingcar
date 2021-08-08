package domain;

import util.RandomNumUtil;

public class MovingStragey implements CarBehavior {

    public static final int CAR_MOVE_CHECK = 4;
    public static final int CAR_ADVANCE = 1;
    public static final int CAR_STOP = 0;

    @Override
    public int carMove() {

        int randomNo = RandomNumUtil.makeRandomNumber();

        if (randomNo > CAR_MOVE_CHECK) {
            return CAR_ADVANCE;
        }

        return CAR_STOP;
    }

}
