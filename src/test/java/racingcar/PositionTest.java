package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("Position 이동 시 위치가 1 증가한다.")
    void 포지션_테스트 () {
        Position position = new Position();
        assertThat(position.move()).isEqualTo(new Position(1));
    }
}
