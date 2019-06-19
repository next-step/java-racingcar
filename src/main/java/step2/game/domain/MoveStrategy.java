package step2.game.domain;

import step2.game.util.RacingGameRandomUtils;

public interface MoveStrategy {
    default boolean isMove() {
        return RacingGameRandomUtils.isMove();
    }

    default Integer getMoveSize() {
        return 1;
    }
}
