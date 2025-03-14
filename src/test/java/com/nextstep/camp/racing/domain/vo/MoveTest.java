package com.nextstep.camp.racing.domain.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveTest {

    @Test
    void move_ShouldBeRandom() {
        boolean hasMoved = false;
        boolean hasNotMoved = false;

        for (int i = 0; i < 100; i++) {
            Move move = Move.decide();
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
