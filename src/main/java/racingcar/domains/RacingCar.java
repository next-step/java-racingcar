package racingcar.domains;

import racingcar.strategies.MoveStrategy;
import racingcar.utils.RandomNumberUtil;

public class RacingCar {

    private int moveCnt;

    public int move(MoveStrategy moveStrategy) {
        if (RandomNumberUtil.isMovable(moveStrategy)) {
            return ++moveCnt;
        }
        return moveCnt;
    }

    public int getMoveCnt() {
        return moveCnt;
    }
}
