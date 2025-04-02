package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveStrategyTest {

    @Test
    @DisplayName("move number 값에 따라서 움직일 수 있는지를 반환한다.")
    void isMovable() {
        assertThat(new MoveStrategy(() -> 4).isMovable()).isTrue();
        assertThat(new MoveStrategy(() -> 3).isMovable()).isFalse();
    }
}