package study.racingcar.strategy;

import study.racingcar.util.RandomUtil;

public class CarMoveStrategy implements MoveStrategy {

    private static final int MOVE_CONDITION = 4;
    private static final int BOUND_NUMBER = 10;
    private RandomUtil randomUtil;

    public CarMoveStrategy(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }

    @Override
    public boolean isMove() {
        return randomUtil.generate(BOUND_NUMBER) >= MOVE_CONDITION;
    }


}
