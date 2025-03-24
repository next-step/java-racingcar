package com.nextstep.camp.racing.domain.vo;

import com.nextstep.camp.racing.domain.strategy.RandomMoveStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveTest {

    @Test
    void move_ShouldBeRandom() {
        boolean hasMoved = false;
        boolean hasNotMoved = false;

        for (int i = 0; i < 100; i++) {
            Move move = Move.decide(RandomMoveStrategy.INSTANCE);
            if (move.isMove()) {
                hasMoved = true;
            } else {
                hasNotMoved = true;
            }
            if (hasMoved && hasNotMoved) {
                break;
            }
        }

        assertThat(hasMoved).isTrue();
        assertThat(hasNotMoved).isTrue();
    }
}
