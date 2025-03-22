package edu.nextstep.camp.carracing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    void 음수_테스트() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치 값에 음수가 들어갈 수 없습니다.");
    }

    @Test
    void 값_동등성_테스트() {
        Position position1 = new Position(5);
        Position position2 = new Position(5);

        assertThat(position1).isEqualTo(position2);
    }
}