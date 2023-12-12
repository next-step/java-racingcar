package race.domain;

import race.util.RandomNumberUtil;

public class RnadomMoveStrategy implements MoveStrategy {
    public static final int FORWARD_NUM = 4;

    @Override
    public boolean movable() {
        return FORWARD_NUM <= RandomNumberUtil.randomNumber();
    }
}
