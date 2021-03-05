package carRacing.model.action;

import carRacing.utils.RandomUtils;

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
