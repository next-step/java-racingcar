package com.nextstep.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovePolicyTest {
    @DisplayName("움직임 가능 여부를 판단할 수 있다.")
    @Test
    void refuelTest() {
        RandomMovePolicy randomMovePolicy = new RandomMovePolicy();

        assertThat(randomMovePolicy.canMove()).isInstanceOf(Boolean.class);
    }
}
