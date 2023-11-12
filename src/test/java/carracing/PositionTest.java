package carracing;

import carracing.domain.car.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    @DisplayName("Position생성/시작점/1")
    void positionStart() {
        // when then
        assertThat(Position.startPosition()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("Position불변/값변경/객체가 새로 생성된다.")
    void positionImmutable() {
        // given
        Position position = Position.startPosition();

        // when
        Position newPosition = position.move(1);

        // then
        assertThat(position.hashCode()).isNotEqualTo(newPosition.hashCode());
    }
}
