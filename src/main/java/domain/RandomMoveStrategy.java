package domain;

import util.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean moveable() {
        return RandomUtil.random() >= 4;
    }
}
