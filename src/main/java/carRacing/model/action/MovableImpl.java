package carRacing.model.action;

import carRacing.utils.RandomUtils;

public class MovableImpl implements Movable{
    private int randomValue;

    @Override
    public boolean MoveOrNot() {
        this.randomValue = RandomUtils.nextInt(10);
        return this.randomValue >= 4 ? true : false;
    }
}
