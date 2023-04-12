package domain;

import util.RandomGenerator;

public  class RandomMoveStrategy implements MoveStrategy{
    @Override
    public boolean isCanMove() {
        return RandomGenerator.getCarRandomInt(10) >= 4;
    }
}
