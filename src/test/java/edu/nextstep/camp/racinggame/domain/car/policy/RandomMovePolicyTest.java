package edu.nextstep.camp.racinggame.domain.car.policy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMovePolicyTest {

    @Test
    public void successToMove() {
        RandomMovePolicy movePolicy = new RandomMovePolicy();
        assertThat(movePolicy.checkMovable(4)).isTrue();
    }

    @Test
    public void failToMove() {
        RandomMovePolicy movePolicy = new RandomMovePolicy();
        assertThat(movePolicy.checkMovable(3)).isFalse();
    }
}
