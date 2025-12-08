package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void 값이_잘_저장된다() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    void 위치로_음수를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 이동하면_증가한_Position을_반환한다() {
        Position position = new Position(0);
        Position movedPosition = position.move();

        assertThat(movedPosition).isEqualTo(new Position(1));
    }

    @Test
    void 여러번_이동하면_누적된_Position을_반환한다() {
        Position position = new Position(0);
        Position movedPosition = position.move().move();

        assertThat(movedPosition).isEqualTo(new Position(2));
    }

    @Test
    void 더_많이_이동한_Position을_반환한다() {
        Position position = new Position(10);
        Position other = new Position(1);

        assertThat(position.biggerPosition(other)).isEqualTo(position);
    }
}
