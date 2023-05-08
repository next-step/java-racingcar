package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("전진할 수 있다.")
    public void move() {
        Position position = new Position(5);
        position.increase();

        assertThat(position.getMoveCount()).isEqualTo(6);
    }

}