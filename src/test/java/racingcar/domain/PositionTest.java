package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void 위치_증가() {
        Position position = new Position(4);
        position.increase();

        assertThat(position).isEqualTo(new Position(5));
    }

    @Test
    void 현재_값() {

        Position position = new Position(4);

        assertThat(position.currentPosition()).isEqualTo(4);
    }

    @Test
    void 최대값_구하기() {
        Position position = new Position(4);

        assertThat(position.max(3)).isEqualTo(4);
    }

    @Test
    void 동일한_값인지() {
        Position position = new Position(4);

        assertThat(position.hasSamePosition(4)).isTrue();
    }

    @Test
    void 동일한_값_아닐경우() {
        Position position = new Position(4);

        assertThat(position.hasSamePosition(5)).isFalse();
    }
}