package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

public class PositionTest {

    @Test
    @DisplayName("Position은 1씩 증가한다.")
    void position() {
        Position position = new Position(1);
        assertThat(position.getPosition()).isEqualTo(1);
        Position movePosition = position.move();
        assertThat(movePosition.getPosition()).isEqualTo(2);
    }

}
