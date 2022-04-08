package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void 처음_생성시_위치는_0() {
        assertThat(new Position().getPosition()).isZero();
    }

    @Test
    void move_호출시_위치_1만큼_증가() {
        Position start = new Position();

        Position end = start.move();

        assertThat(end.getPosition() - start.getPosition()).isOne();
    }
}