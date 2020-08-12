package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @Test
    void 객체_생성() {
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }

    @Test
    void 유효하지_않은_객체_생성() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 포지션_이동_성공() {
        Position movedPosition = new Position(1).move();
        assertThat(movedPosition).isEqualTo(new Position(2));
    }
}
