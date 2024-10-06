package racingcar.refactoring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("Position이 1이 더해졌는지 확인한다.")
    void addPositionTest() {
        Position position = new Position(0);
        assertThat(position.addPosition()).isEqualTo(new Position(1));
    }
}
