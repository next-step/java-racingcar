package study.racing.domain.move;

import study.racing.domain.rule.RandomMoveRule;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMove() {
        return RandomMoveRule.isRandomNumber();
    }
}
