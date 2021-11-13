package com.kakao.racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("Position은 무조껀 0부터 생성이 가능하다.")
    void name() {
        Position position = new Position();
        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("Position은 이동시 1씩 움직인다.")
    void movePosition() {
        Position position = new Position();
        assertThat(position.getValue()).isEqualTo(0);
        position.moveOne();
        assertThat(position.getValue()).isEqualTo(1);
    }
}
