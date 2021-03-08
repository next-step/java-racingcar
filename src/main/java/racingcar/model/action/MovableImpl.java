package racingcar.model.action;

import racingcar.utils.RandomUtils;

public class MovableImpl implements Movable{


    @Override
    public int makeRandomValue() {
        return RandomUtils.nextInt(10);
    }

    @Override
    public boolean MoveOrNot(int randomValue) {
        return randomValue >= 4 ? true : false;
    }
}
