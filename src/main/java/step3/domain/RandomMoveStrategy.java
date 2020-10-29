package step3.domain;

import step3.utils.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean move(int condition) {
        return RandomUtil.generateRandomNumber() >= condition;
    }
}
